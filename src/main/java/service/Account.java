package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account {
    private Client client;
    private double balance;

    public Account(Client client, double balance) {
        this.client = client;
        this.balance = balance;
        // todo: refactoring, mettre le asList dans le new ArrayList
        List<Double> b = Arrays.asList(balance);
        List<Double> l = new ArrayList<>(b);
        State.state.put(this, l);
    }

    public Client getClient() {
        return client;
    }


    public double getBalance() {
        return balance;
    }

}
