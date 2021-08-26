import java.time.LocalDate;
public class Transaction {
    private float credit;
    private float debit;
    private LocalDate date;
    public Transaction(float credit, float debit, LocalDate date){
        this.credit = credit;
        this.debit = debit;
        this.date = date;
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
}
