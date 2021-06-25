package service;

import java.time.ZonedDateTime;

public class History {

    public enum Action {
        SAVE,
        RETRIEVE,
        START
    }

    ZonedDateTime zonedDateTime;
    Double amount;
    Double balance;
    Action action;

    public History(Action action, ZonedDateTime zonedDateTime, Double amount, Double balance) {
        this.action = action;
        this.zonedDateTime = zonedDateTime;
        this.amount = amount;
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "History{" +
                "zonedDateTime=" + zonedDateTime +
                ", amount=" + amount +
                ", balance=" + balance +
                ", action=" + action +
                '}';
    }
}
