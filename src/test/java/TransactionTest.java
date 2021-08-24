import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    @Test
    void createsDepositTransaction(){
        Transaction subject = new Transaction(50, 0, LocalDate.of(19, 2, 19));
        assertEquals(50, subject.getCredit());
        assertEquals(LocalDate.of(19,2,19), subject.getDate());
    }
}
