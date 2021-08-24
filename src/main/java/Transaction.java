import java.time.LocalDate;
public class Transaction {
    private Integer credit;
    private Integer debit;
    private LocalDate date;
    public Transaction(Integer credit, Integer debit, LocalDate date){
        this.credit = credit;
        this.debit = debit;
        this.date = date;
    }

    public Integer getCredit(){
        return this.credit;
    }

    public Integer getDebit(){
        return this.debit;
    }

    public LocalDate getDate(){
        return this.date;
    }
}
