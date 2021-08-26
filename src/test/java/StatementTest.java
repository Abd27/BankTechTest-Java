import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementTest {
    @Test
    void testCanInitializeStatementWithTransactionHistory() throws BankAccountException {
        Bank bankAccount = new Bank();
        bankAccount.deposit(100, LocalDate.of(21, 1, 19));
        Statement subject = new Statement(bankAccount.getTransactionHistory());
        Transaction transactionINBank = bankAccount.getTransactionHistory().get(0);
        Transaction transactionINStatement = subject.getTransactionHistory().get(0);
        assertEquals(transactionINBank, transactionINStatement);
    }
}
