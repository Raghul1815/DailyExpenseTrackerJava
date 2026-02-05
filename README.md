# Daily Expense Tracker (Core Java)

## About the Project
* **Overview:** A console-based Core Java application designed to record and manage day-to-day expenses in a structured format.
* **Objective:** To apply Core Java fundamentals and Object-Oriented Programming (OOPS) principles to solve a real-life financial tracking problem.

## Why I Chose This Project
* **Problem Statement:** I found it difficult to track where my money was being spent without a systematic record.
* **Solution:** Built this tool to capture specific details like Date, Product, and Amount to gain better financial clarity.
* **Skill Development:** This project served as a bridge between theoretical Java concepts and practical implementation.

## Project Architecture & Flow
* **User Interface:** A menu-driven console interface offering:
    * **Add Expense:** Inputting new transaction data.
    * **View Expenses:** Displaying history in a clean format.
    * **Exit:** Safely closing the application.
* **Data Validation:**
    * **Date:** Validated using Regex and logical checks to ensure correct formatting.
    * **Amount:** Validated to ensure only positive numerical values are accepted.
* **Storage & Output:**
    * Details are displayed in the console using a tabular format.
    * Expenses are persistently stored in a text file using a structured layout.
    * **Session Management:** On exit, the file is closed with a separator line to mark the end of the session.

## Concepts & Components Used

### Core Java Fundamentals
* **Classes & Objects:** Used for structuring the expense entity and management logic.
* **Constructors:** To initialize expense objects with specific data.
* **Scanner:** For capturing dynamic user input from the console.
* **File Handling:** Utilized `FileWriter` and `BufferedWriter` for data persistence.
* **Exception Handling:** Managed potential runtime errors during input and file operations.

### Object-Oriented Programming (OOPS)
* **Abstraction:** Implemented via the `ExpenseOperations` interface.
* **Inheritance:** The `ExpenseManager` class implements the interface.
* **Polymorphism:** Used interface references to hold implementing class objects.
* **Encapsulation:** Secured data using private variables and getter methods.

### Additional Concepts
* **Collections Framework:** Used `ArrayList` to manage expense records dynamically.
* **Custom Exception Handling:** Created specific exceptions for invalid user inputs.
* **Regex:** Implemented pattern matching for strict date validation.
* **Formatted Output:** Utilized `printf()` for table alignment in the console.
