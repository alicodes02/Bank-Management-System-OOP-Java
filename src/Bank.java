import java.util.ArrayList;

public class Bank {
    private ArrayList <Account> accounts;
    public Bank() {
        accounts = new ArrayList<Account>();
    }

    public void openAccount(Person person) {

        if(person.getNumberOfAccounts() < 3) {

            Account account = new CurrentAccount(person,0);
            person.incrementNumberOfAccounts();

            accounts.add(account);
        }

        else {
            System.out.println("You Cannot Open more than 3 accounts");
        }
    }

    public void withdrawAmount(Person person, double amount) {

        int index = searchAccount(person.getPersonId());

        if(index != -1) {
            accounts.get(index).withdrawAmount(amount);
        }

        else {

            System.out.println("Account Not Found");
        }
    }

    public void depositAmount(Person person, double amount) {

        int index = searchAccount(person.getPersonId());

        if(index != -1) {
            accounts.get(index).depositAmount(amount);
        }

        else {

            System.out.println("Account Not Found");
        }
    }

    public void closeAccount(Person person) {

        int index = searchAccount(person.getPersonId());

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

            if(accounts.get(i).accountHolder.getPersonId() == id) {
                return i;
            }
        }

        return -1;
    }

    public void showAllAccounts() {

        for(int i = 0; i < accounts.size(); i++) {

            System.out.println(accounts.get(i).toString());
        }
    }
}
