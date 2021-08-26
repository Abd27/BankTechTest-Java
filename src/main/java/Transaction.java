import java.time.LocalDate;
public class Transaction {
    private float credit;
    private float debit;
    private float balance;
    private LocalDate date;
    public Transaction(float credit, float debit, float balance, LocalDate date){
        this.credit = credit;
        this.debit = debit;
        this.date = date;
        this.balance = balance;
    }

    public float getCredit(){
        return this.credit;
    }

    public float getDebit(){
        return this.debit;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public float getBalance(){
        return this.balance;
    }
}
