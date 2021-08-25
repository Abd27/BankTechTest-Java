import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;

public class BankTest {
    Bank subject;
    @BeforeEach
    void createNewBankAccount(){
         subject = new Bank();
    }

    @Test
    void checkBalance(){
        int result = subject.getBalance();
        assertEquals(0, result);
    }

    @Test
    void depositsMoneyToBank() throws BankAccountException{
        subject.deposit(100, LocalDate.of(2021, 8, 16));
        int result = subject.getBalance();
        assertEquals(100, result);
    }

    @Test
    void withdrawMoneyFromBank() throws BankAccountException {
        subject.deposit(100, LocalDate.of(2021, 8, 16));
        subject.withdraw(50, LocalDate.of(2021, 8, 20));
        int result = subject.getBalance();
        assertEquals(50, result);
    }

    @Test
    void raiseExceptionInsufficientBalance(){
        Exception exception = assertThrows(BankAccountException.class, () -> {
                    subject.withdraw(50, LocalDate.of(2021, 7, 14));
        });

        assertEquals(exception.getMessage(), "Insufficient balance");
    }

    @Test
    void raiseExceptionForNegativeDeposit(){
        Exception exception = assertThrows(BankAccountException.class, () -> {
            subject.deposit(-9, LocalDate.of(2021, 8, 11));
        });

        assertEquals(exception.getMessage(), "Invalid deposit");
    }

}
