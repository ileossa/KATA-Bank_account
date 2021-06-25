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

@DisplayName("service.Operation class tests")
@TestMethodOrder(MethodOrderer.Random.class)
@Execution(ExecutionMode.CONCURRENT)
class OperationTest {

    Client c;
    Account a;

    @BeforeEach
    void createNewStack() {
        c = new Client("zeus");
    }

    @ParameterizedTest
    @ValueSource(doubles = {100, 10, 3, -100, 12.5, -12.4})
    public void should_get_solde_by_account(double money) {
        a = new Account(c, money);
        Assertions.assertEquals(money, Operation.sold(a));
    }

    @ParameterizedTest
    @ValueSource(doubles = {100, 10, 3, 12.4})
    public void should_save_positive_money_on_account(double money) {
        double baseBalance = 10;
        a = new Account(c, baseBalance);
        Operation.save(a, money);
        Assertions.assertEquals(baseBalance + money, Operation.sold(a));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-100, -10, -3, -12.5})
    public void should_failed_save_negative_money_on_account(double money) {
        a = new Account(c, money);
        Assertions.assertThrows(OperationError.class, () -> Operation.save(a, money));
    }


    @ParameterizedTest
    @ValueSource(doubles = {100, 10.03, 333, 12.4})
    public void should_retrieve_money_from_own_bank_account_with_positive_balance_at_the_end(double money) {
        int initialBalance = 10000;
        a = new Account(c, initialBalance);
        Operation.retrieve(a, money);
        Assertions.assertEquals(initialBalance - money, Operation.sold(a));
    }


    @ParameterizedTest
    @ValueSource(doubles = {100, 10.03, 333, 12.4})
    public void should_not_retrieve_money_from_own_bank_account_with_negative_balance_at_the_end(double money) {
        a = new Account(c, 10);
        Assertions.assertThrows(OperationError.class, () -> Operation.retrieve(a, money));
    }


    @Test
    public void should_support_multiple_operations() {
        a = new Account(c, 100);
        Operation.save(a, 20);
        Operation.retrieve(a, 10);
        Operation.save(a, 10);
        Operation.retrieve(a, 12.3);
        Operation.save(a, 33.33);
        Operation.retrieve(a, 10);
        Assertions.assertEquals(131.03, Operation.sold(a));
    }


    @Test
    public void should_get_history_on_own_bank_account(TestReporter testReporter) {
        a = new Account(c, 55.5);
        Operation.save(a, 20);
        Assertions.assertEquals(55.5, Operation.check(a).get(0).getBalance());
    }


}