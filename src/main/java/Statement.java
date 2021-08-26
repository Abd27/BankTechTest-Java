import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Statement {
    private static ArrayList<Transaction> transactions;

    public Statement(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return this.transactions;
    }

    public String createStatement() {
        Collections.reverse(transactions);
        String header = "date || credit || debit || balance\n";
        String statement = header;
        for (int i = 0; i < transactions.size(); i++) {
            statement += transactions.get(i).getDate().toString() + " || " + String.format("%.2f", transactions.get(i).getCredit()) + " || " + String.format("%.2f", transactions.get(i).getDebit()) + " || " + String.format("%.2f", transactions.get(i).getBalance()) + "\n";
        }
        return statement.replaceAll(" 0\\.00 ", " - ");
    }
}

