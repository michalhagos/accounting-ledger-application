package com.pluralsight;

import java.util.Scanner;

public class AccountingLedgerApp {
    // created a Scanner to accept the user input it should be a static so that all the methods use it
    static Scanner theScanner = new Scanner(System.in);

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
                    System.out.println("call Add deposit method");
                    break;
                case "P":
                    System.out.println("call make payment method  ");
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
}