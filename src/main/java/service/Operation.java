package service;

import service.exception.OperationError;

import java.util.List;

public class Operation {

    public static double sold(Account a) {
        Double tmp = 0d;
        for (Double v : State.state.get(a)) {
            tmp += v;
        }
        return tmp;
    }


    public static void save(Account a, double money) throws OperationError {
        if (money < 0)
            throw new OperationError(a.getClient().name, money, "SAVE");

        List<Double> operations = State.state.get(a);
        operations.add(money);
        State.state.put(a, operations);
    }

    public static void retrieve(Account a, double money) {
        if (money > sold(a))
            throw new OperationError(a.getClient().name, money, "RETRIEVE");

        List<Double> operations = State.state.get(a);
        double v = money * -1;
        operations.add(v);
        State.state.put(a, operations);
    }

    public static List<History> check(Account a) {
        return State.history.get(a);
    }
}
