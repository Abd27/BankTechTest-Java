import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void depositsMoneyToBank(){
        subject.deposit(100, LocalDate.of(2021, 8, 16));
        int result = subject.getBalance();
        assertEquals(100, result);
    }
}
