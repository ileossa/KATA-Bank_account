import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.Account;
import service.Client;
import service.Operation;
import service.State;
import service.exception.OperationError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@DisplayName("service.Operation class tests")
@TestMethodOrder(MethodOrderer.Random.class)
@Execution(ExecutionMode.CONCURRENT)
class OperationTest {

    Client c;
    Account a;
    State state;

    @BeforeEach
    void createNewStack() {
        c = new Client("zeus");
        state = new State();
    }

    @ParameterizedTest
    @ValueSource(doubles = {100, 10, 3, -100, 12.5, -12.4})
    public void should_get_solde_by_account(double money) {
        a = new Account(c, money);
        Assertions.assertEquals(money, Operation.solde(a));
    }

    @ParameterizedTest
    @ValueSource(doubles = {100, 10, 3, 12.4})
    public void should_save_positive_money_on_account(double money) {
        // creation de l'account avec 10e
        double baseBalance = 10;
        a = new Account(c, baseBalance);

        // on rajoute de l'argent
        Operation.save(a, money);
        Assertions.assertEquals(baseBalance + money, Operation.solde(a));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-100, -10, -3, -12.5})
    public void should_failed_save_negative_money_on_account(double money) {
        a = new Account(c, money);
        Assertions.assertThrows(OperationError.class, ()->Operation.save(a, money));
    }

}