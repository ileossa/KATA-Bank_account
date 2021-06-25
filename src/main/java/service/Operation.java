package service;

import jdk.jshell.spi.ExecutionControl;
import service.exception.OperationError;

import java.util.List;

public class Operation {

    static final int SAVE = -1;


    public static double solde(Account a) {
        Double tmp = 0d;
        for(Double v : State.state.get(a)){
            tmp += v;
        }
        return tmp;
    }


    public static void save(Account a, double money) throws OperationError {
        if (money < 0)
            throw new OperationError(a.getClient().name, money, "SAVE");


        List<Double> operations = State.state.get(a);
        boolean b = operations.add(money);
        if(b)
            State.state.put(a, operations);
    }

    public static void retrieve(Account a, double money) {
        try {
            throw new ExecutionControl.NotImplementedException("not implemented yet");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
    }
}
