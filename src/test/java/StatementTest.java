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

    @Test
    void testCanGenerateStatement() throws BankAccountException{
        Bank bankAccount = new Bank();

        bankAccount.deposit(1000, LocalDate.of(2021, 1, 10));
        bankAccount.deposit(2000, LocalDate.of(2021, 1, 13));
        bankAccount.withdraw(500, LocalDate.of(2021, 1, 14));

        Statement subject = new Statement(bankAccount.getTransactionHistory());

        String outputExample = "date || credit || debit || balance\n" +
                               "2021-01-14 || - || 500.00 || 2500.00\n" +
                               "2021-01-13 || 2000.00 || - || 3000.00\n" +
                               "2021-01-10 || 1000.00 || - || 1000.00\n";
        assertEquals(outputExample, subject.createStatement());


    }
}
