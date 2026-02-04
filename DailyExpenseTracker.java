import java.io.*;
import java.util.*;

interface ExpenseOperations {
    void addExpense(Expense e) throws InvalidExpenseException;
    void showExpenses();
}

class InvalidExpenseException extends Exception {
    InvalidExpenseException(String message) {
        super(message);
    }
}

class Expense {
    private String date;
    private String product;
    private int amount;

    Expense(String date, String product, int amount) {
        this.date = date;
        this.product = product;
        this.amount = amount;
    }

    public String getDate() { return date; }
    public String getProduct() { return product; }
    public int getAmount() { return amount; }
}

class ExpenseManager implements ExpenseOperations {

    private ArrayList<Expense> expenses = new ArrayList<>();
    private final String FILE_NAME = "expenses.txt";
    private boolean isClosed = false;

    private static final String LINE =
            "+--------------------------------------------------------------+";

    private final String TABLE_HEADER =
            LINE + "\n" +
            String.format("| %-4s | %-15s | %-20s | %-12s |\n",
                    "S.No", "Date", "Product", "Amount") +
            LINE + "\n";

    @Override
    public void addExpense(Expense e) throws InvalidExpenseException {

        expenses.add(e);

        try {
            File file = new File(FILE_NAME);
            boolean isNewFile = !file.exists();

            try (BufferedWriter bw =
                         new BufferedWriter(new FileWriter(file, true))) {

                if (isNewFile) {
                    bw.write(TABLE_HEADER);
                }

                bw.write(String.format(
                        "| %-4d | %-15s | %-20s | ₹%-11d |\n",
                        expenses.size(),
                        e.getDate(),
                        e.getProduct(),
                        e.getAmount()
                ));
            }

        } catch (IOException io) {
            throw new InvalidExpenseException("File write error");
        }

        System.out.println("Expense added successfully. ");
    }

    @Override
    public void showExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println(LINE);
        System.out.printf("| %-4s | %-15s | %-20s | %-12s |\n",
                "S.No", "Date", "Product", "Amount");
        System.out.println(LINE);

        int total = 0;

        for (int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);
            System.out.printf("| %-4d | %-15s | %-20s | ₹%-11d |\n",
                    i + 1,
                    e.getDate(),
                    e.getProduct(),
                    e.getAmount());
            total += e.getAmount();
        }

        System.out.println(LINE);
        System.out.println("Total Expense: ₹" + total);
    }

    public void closeFile() throws InvalidExpenseException {

        if (isClosed) return;

        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            bw.write(LINE);
            bw.newLine();
            isClosed = true;

        } catch (IOException e) {
            throw new InvalidExpenseException("Error while closing file");
        }
    }
}

class Validator {

    static boolean isValidDate(String date) {

        // Regex format check
        if (!date.matches("(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4}")) {
            return false;
        }

        String[] parts = date.split("-");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        // February check
        if (month == 2) {
            boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            return leap ? day <= 29 : day <= 28;
        }

        // 30-day months
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }

        return true;
    }

    static boolean isValidAmount(String amtStr) {
        try {
            int amt = Integer.parseInt(amtStr);
            return amt > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

public class DailyExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseOperations manager = new ExpenseManager();

        boolean run = true;

        while (run) {
            System.out.println("\n----- Daily Expense Tracker -----");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Date (DD-MM-YYYY): ");
                        String date = sc.nextLine();

                        if (!Validator.isValidDate(date))
                            throw new InvalidExpenseException("Invalid date");

                        System.out.print("Enter Product: ");
                        String product = sc.nextLine();

                        System.out.print("Enter Amount: ");
                        String amtStr = sc.nextLine();

                        if (!Validator.isValidAmount(amtStr))
                            throw new InvalidExpenseException("Invalid amount");

                        manager.addExpense(
                                new Expense(date, product, Integer.parseInt(amtStr)));
                        break;

                    case 2:
                        manager.showExpenses();
                        break;

                    case 3:
                        ((ExpenseManager) manager).closeFile();
                        run = false;
                        System.out.println("Exiting... Goodbye!!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InvalidExpenseException e) {
                System.out.println("ERROR : " + e.getMessage());
            }
        }

        sc.close();
    }
}
