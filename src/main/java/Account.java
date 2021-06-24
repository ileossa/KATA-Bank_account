import java.util.UUID;

public class Account {
    private Client client;
    private double balance;

    public Account(Client client, double balance) {
        this.client = client;
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }


    public double getBalance() {
        return balance;
    }

}
