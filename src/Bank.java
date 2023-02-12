import java.util.ArrayList;
import java.util.Date;  

public class Bank {

    private ArrayList <Account> accounts;
    ArrayList <TransactionRecord> transactionRecords;

    public Bank() {

        accounts = new ArrayList<Account>();
        transactionRecords = new ArrayList<TransactionRecord>();
    }

    // This function is for opening normal accounts : Current/Saving. 

    public void openAccount(Person person, String accountType) {

        Account account;

        if(person.getNumberOfAccounts() < 3) {

            switch(accountType) {
                
                case "Current" :
                account = new CurrentAccount(person,0,accountType);
                person.incrementNumberOfAccounts();
                accounts.add(account);
                break;

                case "Saving":
                account = new SavingAccount(person,0,accountType);
                person.incrementNumberOfAccounts();
                accounts.add(account);
                break;
            }
        }

        else {

            System.out.println("You Cannot Open more than 3 accounts");
            return;
        }

        System.out.println("Account Created Successfully!!");
    }

    // This function is for opening joint Current account.

    public void openAccount(Person person1, Person person2, String accountType) {

        if(person1.getNumberOfAccounts() > 3 || person2.getNumberOfAccounts() > 3) {

            System.out.println("Maximum Accounts Limit Reached! You cannot open more than 3 accounts.");
            return;
        }

        if(accountType == "Joint") {

            Account account = new CurrentAccount(person1, person2, 0, "Joint");
            person1.incrementNumberOfAccounts();
            person2.incrementNumberOfAccounts();

            accounts.add(account);
        }

        else {
            System.out.println("Only Current Account can have more than 1 owners!!");
            return;
        }

        System.out.println("Account Created Successfully!!");
    }

    public void withdrawAmount(int accountId, double amount) {

        int index = searchAccount(accountId);

        if(index != -1) {

            if(accounts.get(index).withdrawAmount(amount) == true) {

                Date date = new Date();
                TransactionRecord record = new TransactionRecord(accountId, "Withdraw", amount, date);
                transactionRecords.add(record);
            }
        }

        else {

            System.out.println("Account Not Found");
        }
    }

    public void depositAmount(int accountId, double amount) {

        int index = searchAccount(accountId);

        if(index != -1) {

            if(accounts.get(index).depositAmount(amount) == true) {

                Date date = new Date();
                TransactionRecord record = new TransactionRecord(accountId, "Deposit", amount, date);
                transactionRecords.add(record);
            }
        }

        else {

            System.out.println("Account Not Found");
        }
    }

    public void closeAccount(int accountId) {

        int index = searchAccount(accountId);

        if(index == -1) {
            System.out.println("Account Not Found");
        }

        else {
            accounts.remove(index);
            System.out.println("Account Deleted Successfully!");
        }
    }

    private int searchAccount(int id) {

        for(int i = 0; i < accounts.size(); i++) {

            // normal query for current/Saving Accounts...

            if(accounts.get(i).accountHolder1.getPersonId() == id) {
                return i;
            }

            // in case of joint account...

            if(accounts.get(i).accountHolder2 != null) {

                if(accounts.get(i).accountHolder2.getPersonId() == id) {
                    return i;
                }
            }
        }

        return -1;
    }

    public void showAllAccounts() {

        for(int i = 0; i < accounts.size(); i++) {

            System.out.println(accounts.get(i).toString());
        }
    }

    public void showAllTranscations() {

        for(int i = 0; i < transactionRecords.size(); i++) {
            System.out.println(transactionRecords.get(i).toString());
        }
    }

    public void showBankStatement(int accountId) {

        boolean flag = false;

        for(int i = 0; i < transactionRecords.size(); i++) {

            if(transactionRecords.get(i).getAccountId() == accountId) {

                flag = true;
                System.out.println(transactionRecords.get(i).toString()); 
            }
        }

        if(flag == false) {
            System.out.println("Account Not Found!!");
        }
    }  
}
