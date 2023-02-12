public abstract class Account {

    protected Person accountHolder1;
    protected Person accountHolder2;  // 2 account holders in case of joint accounts.
    protected double accountBalance;
    protected boolean accountIsActive;
    private String accountType;

    public Account(Person person, double balance, String accountType) {

        this.accountHolder1 = person;
        this.accountBalance = balance;
        accountIsActive = true;
        this.accountType = accountType;
        this.accountHolder2 = null;
    }

    public Account(Person person1, Person person2, double balance, String accountType) {

        this.accountHolder1 = person1;
        this.accountHolder2 = person2;
        this.accountBalance = balance;
        accountIsActive = true;
        this.accountType = accountType;
    }

    public abstract boolean withdrawAmount(double amount);

    public boolean depositAmount(double amount) {

        if(amount > 0) {
            this.accountBalance += amount;
        }

        else {
            System.out.println("Cannot Deposit Negative Amounts");
            return false;
        }

        System.out.println("Amount Deposited Successfully!");
        return true;
    }

    @Override
    public String toString() {

        String accountDetails;

        if(accountHolder1 != null && accountHolder2 != null) {

            accountDetails = accountHolder1.toString() + "\n" + accountHolder2.toString();
        }

        else {
           accountDetails = accountHolder1.toString();
        }

        accountDetails += "Balance : " + accountBalance + "\n" + "Active : " + 
        accountIsActive + "\n" + "Account Type : " + this.accountType +  "\n\n";
        
        return accountDetails;
    }

    public void generateBankStatement() {
        
    }
}
