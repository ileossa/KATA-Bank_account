package service;

import service.exception.OperationError;

import java.time.ZonedDateTime;
import java.util.List;

import static service.History.Action.RETRIEVE;
import static service.History.Action.SAVE;

public class Operation {

    public static double sold(Account a) {
        List<History> historyList = State.get(a);
        return historyList.get(historyList.size()-1).balance;
    }


    public static void save(Account a, double amount) throws OperationError {
        if (amount < 0)
            throw new OperationError(a.getClient().name, amount, "SAVE");
        action(a, amount, amount, SAVE);
    }

    public static void retrieve(Account a, double amount) {
        if (amount > sold(a))
            throw new OperationError(a.getClient().name, amount, "RETRIEVE");
        action(a, amount, amount * -1, RETRIEVE);
    }


    public static List<History> check(Account a) {
        return State.get(a);
    }


    private static void action(Account a, double amount, double v, History.Action retrieve) {
        List<History> history = State.get(a);
        double newBalance = history.get(history.size() - 1).balance + (v);
        history.add(new History(retrieve, ZonedDateTime.now(), amount, newBalance));
        State.put(a, history);
    }
}

