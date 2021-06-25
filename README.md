# Bank account kata
Think of your personal bank account experience When in doubt, go for the simplest solution

# Requirements
- Deposit and Withdrawal
- service.Account statement (date, amount, balance)
- Statement printing

# User Stories
##### US 1:
**In order to** save money  
**As a** bank client  
**I want to** make a deposit in my account

##### US 2:
**In order to** retrieve some or all of my savings  
**As a** bank client  
**I want to** make a withdrawal from my account

##### US 3:
**In order to** check my operations  
**As a** bank client  
**I want to** see the history (operation, date, amount, balance)  of my operations  


# Simple Exemple
```java
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
```

### Output
```java
[
    History{
        zonedDateTime=2021-06-25T15:45:31.962396+02:00[Europe/Paris], 
        amount=0.0, 
        balance=100.0, 
        action=START
    }, 
    History{zonedDateTime=2021-06-25T15:45:31.968027+02:00[Europe/Paris], 
        amount=10.0, 
        balance=90.0, 
        action=RETRIEVE
    }, 
    History{zonedDateTime=2021-06-25T15:45:31.968078+02:00[Europe/Paris], 
        amount=10.0, 
        balance=80.0, 
        action=RETRIEVE
    }, 
    History{zonedDateTime=2021-06-25T15:45:31.968103+02:00[Europe/Paris], 
        amount=200.0, 
        balance=280.0, 
        action=SAVE
    }
]
```