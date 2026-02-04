Daily Expense Tracker (Core Java)
About the Project

The Daily Expense Tracker is a console-based Core Java application designed to help users record and manage their day-to-day expenses in a structured manner.

The project focuses on applying Core Java fundamentals and Object-Oriented Programming (OOPS) concepts to solve a real-life problem.

Why I Chose This Project

I realized that I often made mistakes while managing and tracking my daily expenses.

Without proper tracking, it became difficult to understand where my money was being spent.

To overcome this issue, I decided to build a Daily Expense Tracker that records expense details such as date, product, and amount.

This project also helped me practically apply Core Java concepts instead of learning them only theoretically.

Project Architecture & Flow
Application Flow

The user selects an option from the menu:

Add Expense

View Expenses

Exit

While adding an expense:

The date is validated using Regex and logical checks.

The amount is validated to ensure it is a positive number.

Expense details are:

Displayed in a tabular format in the console.

Stored in a text file in tabular format.

On exit:

The file is properly closed with a closing separator line to mark the end of the session.

Concepts & Components Used
Core Java Concepts

Classes and Objects

Constructors

Scanner for user input

File Handling (FileWriter, BufferedWriter)

Exception Handling

OOPS Concepts (All Four Pillars)

Abstraction – Interface ExpenseOperations

Inheritance – ExpenseManager implements the interface

Polymorphism – Interface reference holding the implementing class object

Encapsulation – Private variables accessed through getter methods

Additional Concepts

Custom Exception Handling

Regular Expression (Regex) validation

Formatted output using printf()

Collection Framework (ArrayList)
