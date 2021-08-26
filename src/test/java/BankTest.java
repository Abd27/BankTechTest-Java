import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;

public class BankTest {
    Bank subject;
    @BeforeEach
    void createNewBankAccount() throws BankAccountException {
        subject = new Bank();
        subject.deposit(100f, LocalDate.of(2021, 8, 16));
    }

    @Test
    void checkBalance(){
        float result = subject.getBalance();
        assertEquals(100, result);
    }

    @Test
    void depositsMoneyToBank(){
        float result = subject.getBalance();
        assertEquals(100, result);
    }

    @Test
    void withdrawMoneyFromBank() throws BankAccountException{
        subject.withdraw(50, LocalDate.of(2021, 8, 20));
        float result = subject.getBalance();
        assertEquals(50, result);
    }

    @Test
    void raiseExceptionInsufficientBalance(){
        Exception exception = assertThrows(BankAccountException.class, () -> {
                    subject.withdraw(150, LocalDate.of(2021, 7, 14));
        });

        assertEquals(exception.getMessage(), "Insufficient balance");
    }

    @Test
    void raiseExceptionForNegativeDeposit() throws BankAccountException{
        Exception exception = assertThrows(BankAccountException.class, () -> {
            subject.deposit(-9, LocalDate.of(2021, 8, 11));
        });

        assertEquals(exception.getMessage(), "Invalid deposit");
    }

    @Test
    void canCreateTransactionAtDesposit(){
        Transaction transaction = subject.getTransactionHistory().get(0);
        assertEquals(100, transaction.getCredit());
        assertEquals(LocalDate.of(2021,8,16), transaction.getDate());
    }

    @Test
    void canCreateTransactionAtWithdrawal() throws BankAccountException{
        subject.withdraw(50, LocalDate.of(21, 8, 21));
        Transaction transaction = subject.getTransactionHistory().get(1);
        assertEquals(50, transaction.getDebit());
        assertEquals(LocalDate.of(21,8,21), transaction.getDate());
        assertEquals(50, transaction.getBalance());
    }

    @Test
    void generatesTheStatement() throws BankAccountException{
        Bank bankAccount = new Bank();

        bankAccount.deposit(1000, LocalDate.of(2021, 1, 10));

        bankAccount.deposit(2000, LocalDate.of(2021, 1, 13));

        bankAccount.withdraw(500, LocalDate.of(2021, 1, 14));

        String outputExample = "date || credit || debit || balance\n" +
                "2021-01-14 || - || 500.00 || 2500.00\n" +
                "2021-01-13 || 2000.00 || - || 3000.00\n" +
                "2021-01-10 || 1000.00 || - || 1000.00\n";
        assertEquals(outputExample, bankAccount.generateStatement());

    }
}
