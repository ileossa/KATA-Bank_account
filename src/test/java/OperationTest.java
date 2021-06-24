import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@DisplayName("Bank account kata")
@TestMethodOrder(MethodOrderer.Random.class)
@Execution(ExecutionMode.CONCURRENT)
class OperationTest {

    Client c;
    Account a;

    @BeforeEach
    void createNewStack() {
        c = new Client("zeus");
        a = new Account(c, 100);
    }

    @Test
    public void should_get_solde_by_account() {
        Assertions.assertEquals(100, Operation.solde(a));

    }

}