import java.time.LocalDate;
public class Transaction {
    private Integer credit;
    private LocalDate date;
    public Transaction(Integer credit, Integer debit, LocalDate date){
        this.credit = credit;
        this.date = date;
    }

    public Integer getCredit(){
        return this.credit;
    }

    public LocalDate getDate(){
        return this.date;
    }
}
