package bank;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    private String type;
    private double amount;
    private double balanceAfter;
    private LocalDateTime dateTime;

    public Transaction(String type, double amount, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction [Type=" + type + ", Amount=" + amount + ", Balance After=" + balanceAfter + ", Date and Time=" + dateTime + "]";
    }
}
