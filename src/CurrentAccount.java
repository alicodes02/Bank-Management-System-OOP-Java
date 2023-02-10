public class CurrentAccount extends Account {

    public CurrentAccount(Person person, double balance) {
        super(person, balance);
    }

    public void withdrawAmount(double amount) {

        if(this.accountBalance >= amount) {
            this.accountBalance -= amount;
        }

        else {
            System.out.println("Insufficient Account Balance!");
        }
    }

    public void depositAmount(double amount) {

        if(amount > 0) {
            this.accountBalance += amount;
        }

        else {
            System.out.println("Cannot Deposit Negative Amounts");
        }
    }
}
