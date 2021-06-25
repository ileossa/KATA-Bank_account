package service;

import service.exception.OperationError;

import java.time.ZonedDateTime;
import java.util.List;

import static service.History.Action.SAVE;

public class Operation {

    public static double sold(Account a) {
        List<History> historyList = State.get(a);
        return historyList.get(historyList.size()-1).balance;
    }


    public static void save(Account a, double amount) throws OperationError {
        if (amount < 0)
            throw new OperationError(a.getClient().name, amount, "SAVE");

        List<History> history = State.get(a);
        double newBalance = history.get(history.size() - 1).balance + amount;
        history.add(new History(SAVE, ZonedDateTime.now(), amount, newBalance));
        State.put(a, history);
    }

    public static void retrieve(Account a, double money) {
//        if (money > sold(a))
//            throw new OperationError(a.getClient().name, money, "RETRIEVE");
//
//        List<Double> operations = State.state.get(a);
//        double v = money * -1;
//        operations.add(v);
//        State.put(a, operations);
        throw new UnsupportedOperationException("not implemented");
    }

    public static List<History> check(Account a) {
//        return State.history.get(a);
        throw new UnsupportedOperationException("not implemented");
    }
}
