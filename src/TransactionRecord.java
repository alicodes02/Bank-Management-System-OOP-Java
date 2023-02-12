import java.text.SimpleDateFormat;  
import java.util.Date;  

public class TransactionRecord {

    private SimpleDateFormat formatter;  
    private Date date;
    private int accountId;
    private String transactionType;
    private double amount;

    TransactionRecord(int accountId, String type, double amount, Date date) {

        this.accountId = accountId;
        this.transactionType = type;
        this.amount = amount;
        this.date = date;

        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  

    }

    @Override
    public String toString() {

        String details;

        details = "Account ID : " + this.accountId + "\nTranscation Type : " +  this.transactionType +
        "\nAmount : " + this.amount + "\nDate/Time : " +  formatter.format(date) + "\n\n";

        return details;
    }

    public int getAccountId() {
        return this.accountId;
    }

}
