package service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account {
    private Client client;

    public Account(Client client, double balance) {
        this.client = client;

        //todo: remove this state
        List<Double> l = new ArrayList<>(Arrays.asList(balance));
        State.state.put(this, l);

        List<History> hl = new ArrayList<>(Arrays.asList(new History(
                History.Action.START,
                ZonedDateTime.now(),
                (double) 0,
                balance)));
        State.history.put(this, hl);
    }

    public Client getClient() {
        return client;
    }


}
