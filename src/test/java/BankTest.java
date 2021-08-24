import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    @Test
    void checkBalance(){
        Bank subject = new Bank();
        int result = subject.getBalance();
        assertEquals(0, result);
    }
}
