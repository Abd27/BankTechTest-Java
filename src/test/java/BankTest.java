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
        subject.deposit(100, LocalDate.of(2021, 8, 16));
    }

    @Test
    void checkBalance(){
        int result = subject.getBalance();
        assertEquals(100, result);
    }

    @Test
    void depositsMoneyToBank(){
        int result = subject.getBalance();
        assertEquals(100, result);
    }

    @Test
    void withdrawMoneyFromBank() throws BankAccountException {
        subject.withdraw(50, LocalDate.of(2021, 8, 20));
        int result = subject.getBalance();
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
    void raiseExceptionForNegativeDeposit(){
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
    }
}
