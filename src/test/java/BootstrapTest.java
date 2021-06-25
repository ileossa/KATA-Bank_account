import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.Account;
import service.Client;

@DisplayName("Bank account kata")
@TestMethodOrder(MethodOrderer.Random.class)
@Execution(ExecutionMode.CONCURRENT)
class BootstrapTest {

    Client c;
    Account a;

//    @Test
//    @DisplayName("instantiated new Boostrap.class object")
////    @Order(1)
//    void isInstantiatedWhitNew(){
//        new Bootstrap();
//    }

    @Nested
    @DisplayName("US 1")
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class US1 {

        @BeforeEach
        void createNewStack() {
            c = new Client("Adam");
            a = new Account(c, 100);
        }

        @ParameterizedTest
        @ValueSource(doubles = {1, 10, 1000, 12.5, 0})
        void i_would_like_save_my_money_on_my_bank_account(int money){
//            a.getClient().name
        }

        @ParameterizedTest // remplae le @test
        @ValueSource(doubles = {-1, -10, -1.3})
        void i_cant_save_negative_number_on_my_account(int i){
//            Assertions.assertDoesNotThrow(()->b.run());
        }

    }

}