package com.pluralsight;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountingLedgerApp {
    // created a Scanner to accept the user input it should be a static so that all the methods use it
    static Scanner theScanner = new Scanner(System.in);
// creating new constant variable for my transaction.csv file
    static final String FILE_NAME = "src/main/resources/transactions.csv";
    static ArrayList<Transaction> transactions = new ArrayList <>();


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
                    //addDeposit();
                    break;
                case "P":
                    System.out.println("wait for the payment the method ");;
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
                    System.out.println("call a method for printing all entries ");
                    break;
                case "D":
                    System.out.println("call a method for printing all deposits )");
                    break;
                case "P":
                    System.out.println("call a method for printing all payments )");
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
                    System.out.println("call Month To Date  method");
                    break;
                case 2:
                    System.out.println("call Previous Month method  ");
                    break;
                case 3:
                    System.out.println("call Year To Date method  ");
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
                    String date        = parts[0]; // e.g. 2023-04-15
                    String time        = parts[1]; // e.g. 10:13:25
                    String description = parts[2]; // e.g. ergonomic keyboard
                    String vendor      = parts[3]; // e.g. Amazon
                    double amount      = Double.parseDouble(parts[4]); // e.g. -89.50

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



}