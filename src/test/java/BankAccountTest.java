import org.example.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



@DisplayName("Test BankAccount class")
public class BankAccountTest {

    @Test
    @DisplayName("withdraw 500 successfully")
    public void testWithdraw(){
        BankAccount bankAccount=new BankAccount(500,-1000);
        bankAccount.withdraw(300);
        assertEquals(200,bankAccount.getBalance());
    }

    @Test
    @DisplayName("deposit 400 successfully")
    public void testDeposit(){
        BankAccount bankAccount=new BankAccount(400,0);
        bankAccount.deposit(600);
        assertEquals(1000,bankAccount.getBalance());
    }
    @Test
    @DisplayName("withdraw will become negative")
    public void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount=new BankAccount(500,-1000);
        bankAccount.withdraw(800);
        assertNotEquals(0,bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test account activation after creation ")
    public void testActive(){
        BankAccount bankAccount=new BankAccount(500,0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test set holder name")
    public void testHolderNameSet(){
        BankAccount bankAccount=new BankAccount(500,0);
        bankAccount.setHolderName("Fevzi");
        assertNotNull(bankAccount.getHolderName());
    }


    @Test
    @DisplayName("Test that we cannot withdraw below minimum")
    public void testNoWithdrawBelowMinimum(){
        BankAccount bankAccount=new BankAccount(500,-1000);
        assertThrows(RuntimeException.class,()->bankAccount.withdraw(2000));
    }


}
