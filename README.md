# Accounting Ledger App

A simple Java console application for tracking personal or small business transactions. You can log deposits and payments, then view them in a ledger with filtering and reporting options.

---

## What It Does

- Add deposits and payments (debits) with a vendor, description, amount, and automatic timestamp
- View all transactions in a formatted ledger
- Filter by deposits only or payments only
- Run reports by time period or search by vendor
- Transactions are saved to a CSV file so your data persists between sessions

---

## Project Structure

```
src/
└── main/
    ├── java/com/pluralsight/
    │   ├── AccountingLedgerApp.java   ← main app logic and menus
    │   └── Transaction.java           ← transaction model (fields, constructor, getters/setters)
    └── resources/
        └── transaction.csv            ← where transactions are saved and loaded from
```

---

## How to Run

1. Clone or download the project
2. Open it in your IDE (IntelliJ, Eclipse, etc.)
3. Run `AccountingLedgerApp.java`
4. Use the menu options to navigate

---

## Menu Overview

### Main Menu
```
D) Add Deposit
P) Make Payment (Debit)
L) Ledger
X) Exit
```

### Ledger Screen
```
A) All Entries
D) Deposits only
P) Payments only
R) Reports
H) Home
```

### Reports Screen
```
1) Month To Date
2) Previous Month
3) Year To Date
4) Previous Year
5) Search by Vendor
0) Back
```

---

## Transaction File Format

Transactions are stored in `transaction.csv` using pipe-separated values:

```
date|time|description|vendor|amount
```

**Example:**
```
2025-04-28|14:32:10|Office chair|Amazon|259.99
2025-04-29|09:15:44|Electric bill|City Power|-120.00
```

Deposits are positive amounts. Payments are stored as negative numbers.

---

## Technologies Used

- Java 17+
- Standard Java I/O (`BufferedReader`, `BufferedWriter`, `FileWriter`)
- `ArrayList` for in-memory transaction storage
- `LocalDateTime` for automatic date/time stamping

---


## Author

Built as a Pluralsight capstone project to practice Java fundamentals — file I/O, OOP, `ArrayList`, and building interactive console menus.
