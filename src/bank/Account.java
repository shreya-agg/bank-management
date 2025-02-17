package bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private User user;
    private double balance;
    private List<Transaction> transactions;

    public Account(User user) {
        this.user = user;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount, balance));
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount, balance));
            return true;
        } else {
            return false;
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

