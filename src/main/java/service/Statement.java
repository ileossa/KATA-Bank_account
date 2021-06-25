package service;

import java.util.List;

public interface Statement {

    List<History> get(Account a);
    List<History> put(Account a, List<History> operations);
}
