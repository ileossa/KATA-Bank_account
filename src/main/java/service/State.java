package service;

import java.util.HashMap;
import java.util.List;

public class State {

    private static HashMap<Account, List<History>> history = new HashMap<>();

    public static List<History> get(Account a) {
        return history.get(a);
    }

    public static List<History> put(Account a, List<History> operations) {
        return history.put(a, operations);
    }
}

