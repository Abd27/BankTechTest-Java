import java.time.LocalDate;
import java.util.ArrayList;

public class Bank {
    private float balance;
    private ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();

    public Bank () {
        balance = 0;
    }

    public float getBalance(){
        return balance;
    }

    public ArrayList<Transaction> getTransactionHistory(){
        return transactionHistory;
    }

    public void deposit(float amount, LocalDate date) throws BankAccountException {
        if(amount <= 0){
            throw new BankAccountException("Invalid deposit");
        } else {
            balance += amount;
            transactionHistory.add(new Transaction(amount, 0, date));
        }
    }

    public void withdraw(Integer amount, LocalDate date) throws BankAccountException {
        if(amount > balance){
            throw new BankAccountException("Insufficient balance");
        } else {
            balance -= amount;
            transactionHistory.add(new Transaction(0, amount, date));
        }
    }

}
