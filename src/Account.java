public abstract class Account {

    protected Person accountHolder;
    protected double accountBalance;
    protected boolean accountIsActive;

    public Account(Person person, double balance) {
        this.accountHolder = person;
        this.accountBalance = balance;
        accountIsActive = true;
    }

    public abstract void withdrawAmount(double amount);
    public abstract void depositAmount(double amount);

    @Override
    public String toString() {

        String accountDetails;

        accountDetails = accountHolder.toString() + "Balance : " + accountBalance + "\n" + "Active : " + accountIsActive
        + "\n\n";
        return accountDetails;
    }
}
