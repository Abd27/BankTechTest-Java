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
}
