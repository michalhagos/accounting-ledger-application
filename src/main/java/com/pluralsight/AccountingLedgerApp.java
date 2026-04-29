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

    static void ledgerScreen() {
        boolean isLedger = true;
        // put the menu/ print it out inside a while loop
        while (isLedger) {

            System.out.println("**********************");
            System.out.println(" Ledger Screen ");
            System.out.println("**********************");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.println("**********************");
            System.out.print("Enter Your Choice (A, D, P, R or H ): ");

            String choice = theScanner.nextLine().trim().toUpperCase();
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
                    System.out.println("call show reports method ");
                    break;
                case "H":
                    isLedger = false;
                    System.out.println("Go Back to Home screen )");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }


        }


    }}
