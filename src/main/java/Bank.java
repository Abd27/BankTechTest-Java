import java.time.LocalDate;

public class Bank {
    private Integer balance;

    public Bank () {
        balance = 0;
    }

    public Integer getBalance(){
        return balance;
    }

    public void deposit(Integer amount, LocalDate date){
        balance += amount;
    }

    public void withdraw(Integer amount, LocalDate date) throws Exception {
        if(amount > balance){
            throw new Exception("Insufficient balance");
        } else {
            balance -= amount;
        }

    }
}
