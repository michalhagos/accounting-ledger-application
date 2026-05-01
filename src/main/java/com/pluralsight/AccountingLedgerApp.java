package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountingLedgerApp {
    static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // created a Scanner to accept the user input it should be a static so that all the methods use it
    static Scanner theScanner = new Scanner(System.in);
    // creating new constant variable for my transaction.csv file
    static final String FILE_NAME = "src/main/resources/transaction.csv";
    static ArrayList<Transaction> transactions = new ArrayList<>();


    public static void main(String[] args) {


        // create a variable isRunning to create a while loop that shows the menu repeatedly
        boolean isRunning = true;
        // put the menu/ print it out inside a while loop
        while (isRunning) {
            System.out.println("**********************");
            System.out.println("Accounting Ledger App");
            System.out.println("**********************");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment(Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.println("**********************");
// ask the user for their choice
            System.out.print("Enter Your Choice (D, P, L or X): ");
// save the choice in a String variable
            String choice = theScanner.nextLine().trim().toUpperCase();
// use a switch statement to match the choice to the methods
            switch (choice) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    addPayment();

                    break;
                case "L":
                    ledgerScreen();
                    break;
                case "X":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }

        System.out.println("Thank you for using my Accounting Ledger App! See you later! ");
    } // main ends here

    // create new method to show the ledger screen and a boolean variable that help to check the menu in a while loop
    static void ledgerScreen() {
        boolean isLedger = true;
        // put the menu in / print it out inside a while loop
        while (isLedger) {
// print the Ledger menu to the screen and ask the user what entries they want to see
            System.out.println("**********************");
            System.out.println(" Ledger Screen ");
            System.out.println("**********************");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.println("**********************");
            // Ask the user for the choice to type it in letters
            System.out.print("Enter Your Choice (A, D, P, R or H ): ");

// create a variable to save the user input
            String choice = theScanner.nextLine().trim().toUpperCase();
            // below is a switch statement to match the user choice with the methods or back to the previous screen
            switch (choice) {
                case "A":
                    displayAllEntries();
                    break;
                case "D":
                    displayDepositEntries();
                    break;
                case "P":
                    displayPaymentEntries();
                    break;
                case "R":
                    reportScreen();
                    break;
                case "H":
                    isLedger = false;
                    System.out.println("Go Back to Home screen )");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }


        }


    }

    // create a method for the report screen to be show when the user chooses R in the ledger screen
    static void reportScreen() {
// create a boolean variable to help run the while loop
        boolean isRunning = true;
// use a while loop to show the menu for reports from the transaction file
        while (isRunning) {

            System.out.println("**********************");
            System.out.println(" REPORTS");
            System.out.println("**********************");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search Vendor");
            System.out.println("0) Back");
            System.out.println("**********************");

            System.out.print("Enter Your Choice 1, 2, 3, 4, 5 or 0 : ");
// save the user choice in a variable
            int choice = theScanner.nextInt();
            // eat the line so that the next input is asked correctly
            theScanner.nextLine();
// create a switch statement to match the choice with the methods for different ways of showing the transaction history
            switch (choice) {
                case 1:
                    reportMonthToDate();
                    break;
                case 2:
                    reportPreviousMonth();
                    break;
                case 3:
                    reportYearToDate();
                    break;
                case 4:
                    System.out.println("call Previous Year method  ");
                    break;
                case 5:
                    System.out.println("call Search Vendor method  ");
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void loadFromFile() {
        transactions.clear();

        // create a File object that points to my transactions.csv
        //  File class imported at the top to help
        File file = new File(FILE_NAME);

        // if the file doesn't exist yet, just skip loading /no runtime error needed
        if (!file.exists()) {
            System.out.println("No file found at: " + file.getAbsolutePath());
            return;
        }

        try {
            // BufferedReader reads the file line by line
            BufferedReader bufReader = new BufferedReader(new FileReader(file));

            // declare a new string variable line
            String line;

            // keep reading lines until there are no more lines to read /readLine returns null at the end
            while ((line = bufReader.readLine()) != null) {

                // split the line into 5 parts using | as the separator to store it in an array
                // \\| is needed because | is a special character in Java
                String[] parts = line.split("\\|");

                // only process the line if it has exactly 5 parts
                // this protects us from blank lines or badly formatted lines
                if (parts.length == 5) {
                    String date = parts[0]; // e.g. 2023-04-15
                    String time = parts[1]; // e.g. 10:13:25
                    String description = parts[2]; // e.g. ergonomic keyboard
                    String vendor = parts[3]; // e.g. Amazon
                    double amount = Double.parseDouble(parts[4]); // e.g. -89.50

                    // create a new Transaction object with the 5 values using the constructor
                    // and add it to our transactions ArrayList
                    transactions.add(new Transaction(date, time, description, vendor, amount));
                }
            }
            //  closing the reader when done to free up some memory
            bufReader.close();

        } catch (IOException e) {
            // if something goes wrong reading the file, print the error
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    public static void addDeposit() {
        System.out.println("Vendor: ");
        String vendor = theScanner.nextLine();
        System.out.println("Description: ");
        String description = theScanner.nextLine();
        System.out.println("amount: ");
        String amount = theScanner.nextLine();

        LocalDateTime now = LocalDateTime.now();
        Transaction deposit = new Transaction(now.format(dateFormatter), now.format(timeFormatter), description, vendor, Double.parseDouble(amount));
        saveTransaction(deposit);

    }

    public static void saveTransaction(Transaction transaction) {

        try {
            // create a FileWriter //use appent set to true if you want to append to the file instead of overwrting the contents
            FileWriter fileWriter = new FileWriter("src/main/resources/transaction.csv", true);
            // create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            // write to the file
            bufWriter.write(transaction.toFileString() + "\n");

            // close the writer
            bufWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
        }

    }

    public static void addPayment() {
        System.out.println("Vendor: ");
        String vendor = theScanner.nextLine();
        System.out.println("Description: ");
        String description = theScanner.nextLine();
        System.out.println("amount: ");
        String amount = theScanner.nextLine();

        LocalDateTime now = LocalDateTime.now();
        Transaction deposit = new Transaction(now.format(dateFormatter), now.format(timeFormatter), description, vendor, Double.parseDouble(amount) * -1);
        saveTransaction(deposit);

    }
// added a method to show all the entries on the ledger screen
    public static void displayAllEntries() {
        loadFromFile();
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());

        }

    }

    // added a method to show only the deposit entries on the ledger screen
    public static void displayDepositEntries() {
        loadFromFile();
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0) {
                System.out.println(transaction);
            }
        }
    }
    // added a method to show only the payment entries on the ledger screen
    public static void displayPaymentEntries() {
        loadFromFile();
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);
            }
        }
    }
    public static void reportMonthToDate() {
        // load all transactions from the csv file into the ArrayList
        loadFromFile();
        // get the current date and time
        LocalDateTime now = LocalDateTime.now();
        // loop through each transaction and check if it matches the current month and year
        for (Transaction transaction : transactions) {
            // parse the date string into a LocalDate object so we can compare it
            LocalDate date = LocalDate.parse(transaction.getDate());
            // only print if the transaction is in the same month and year as today
            if (date.getYear() == now.getYear() && date.getMonthValue() == now.getMonthValue()) {
                System.out.println(transaction);
            }
        }
    }

    public static void reportPreviousMonth() {
        // load all transactions from the csv file into the ArrayList
        loadFromFile();
        // get the current date and time
        LocalDateTime now = LocalDateTime.now();
        // subtract one month from today to get last month
        LocalDateTime lastMonth = now.minusMonths(1);
        // loop through each transaction and check if it belongs to last month
        for (Transaction transaction : transactions) {
            // parse the date string into a LocalDate object so we can compare it
            LocalDate date = LocalDate.parse(transaction.getDate());
            // only print if the transaction is in the same month and year as last month
            if (date.getYear() == lastMonth.getYear() && date.getMonthValue() == lastMonth.getMonthValue()) {
                System.out.println(transaction);
            }
        }
    }

    public static void reportYearToDate() {
        // load all transactions from the csv file into the ArrayList
        loadFromFile();
        // get just the current year as an int to compare against
        int currentYear = LocalDateTime.now().getYear();
        // loop through each transaction and check if it belongs to the current year
        for (Transaction transaction : transactions) {
            // parse the date string into a LocalDate object so we can compare it
            LocalDate date = LocalDate.parse(transaction.getDate());
            // only print if the transaction year matches the current year
            if (date.getYear() == currentYear) {
                System.out.println(transaction);
            }
        }
    }

} // end of class



