package bank;

import java.util.Scanner;

public class BankSystem {
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bank.loadFromFile();
        while (true) {
            System.out.println("\nBank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Save and Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    bank.saveToFile();
                    System.out.println("Data saved. Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        bank.createAccount(new User(username, password));
        System.out.println("Account created.");
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        Account account = bank.getAccount(username);
        if (account != null && account.getUser().checkPassword(password)) {
            accountMenu(scanner, account);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void accountMenu(Scanner scanner, Account account) {
        while (true) {
            System.out.println("\nAccount Menu");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    depositMoney(scanner, account);
                    break;
                case 2:
                    withdrawMoney(scanner, account);
                    break;
                case 3:
                    checkBalance(account);
                    break;
                case 4:
                    viewTransactionHistory(account);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void depositMoney(Scanner scanner, Account account) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Amount deposited.");
    }

    private static void withdrawMoney(Scanner scanner, Account account) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Amount withdrawn.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private static void checkBalance(Account account) {
        System.out.println("Current balance: " + account.getBalance());
    }

    private static void viewTransactionHistory(Account account) {
        System.out.println("Transaction History:");
        for (Transaction transaction : account.getTransactions()) {
            System.out.println(transaction);
        }
    }
}
