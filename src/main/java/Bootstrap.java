import jdk.jshell.spi.ExecutionControl;
import service.Account;
import service.Client;
import service.Operation;

import java.util.Arrays;

public class Bootstrap {
    static Client c = new Client("Toto");
    static Account a = new Account(c, 100);


    public static void main(String[] args){
        Operation.retrieve(a, 10);
        Operation.retrieve(a, 10);
        Operation.save(a, 200);
        Operation.sold(a);
        String s = Operation.check(a).toString();
        System.out.println(s);
    }

}
