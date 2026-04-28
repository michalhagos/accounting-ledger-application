package com.pluralsight;

import java.util.Scanner;

public class AccountingLedgerApp {
    static Scanner theScanner = new Scanner(System.in);
    public static void main(String[] args) {
boolean isRunning = true;
while (isRunning){
        System.out.println("**********************");
        System.out.println("Accounting Ledger App");
        System.out.println("**********************");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment(Debit)");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
        System.out.println("**********************");

        System.out.print("Enter Your Choice (D, P, L or X): ");

       String choice = theScanner.nextLine().trim().toUpperCase();

        switch (choice) {
            case "D":
                System.out.println("call Add deposit method");
                break;
            case "P":
                System.out.println("call make payment method  ");
                break;
            case "L":
                System.out.println("call ledger screen method ");
                break;
            case "X":
                isRunning = false;
                break;
            default:
                System.out.println("Invalid Choice");

        }

        }


        System.out.println("Thank you for using my Accounting Ledger App! See you later! ");
    }

}
