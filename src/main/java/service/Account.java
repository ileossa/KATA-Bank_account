package service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private final Client client;

    public Account(Client client, double balance) {
        this.client = client;

        List<History> hl = new ArrayList<>(List.of(new History(
                History.Action.START,
                ZonedDateTime.now(),
                (double) 0,
                balance)));
        State.put(this, hl);
    }

    public Client getClient() {
        return client;
    }


}
