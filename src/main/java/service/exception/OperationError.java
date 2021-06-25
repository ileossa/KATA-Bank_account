package service.exception;

public class OperationError extends RuntimeException{

    public OperationError(String account, double money, String operation) {
        super(String.format("operation error, when %s %f %s", operation, money, account));
    }

}

