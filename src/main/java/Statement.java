import java.util.ArrayList;
import java.util.List;

public class Statement {
    private static ArrayList<Transaction> transactions;

    public Statement(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return this.transactions;
    }
}
