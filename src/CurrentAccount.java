public class CurrentAccount extends Account {

    public CurrentAccount(Person person, double balance,String accountType) {
        super(person, balance,accountType);
    }

    public CurrentAccount(Person person1,Person person2, double balance,String accountType) {
        super(person1, person2, balance,accountType);
    }

    public boolean withdrawAmount(double amount) {

        if(this.accountBalance >= amount) {
            this.accountBalance -= amount;
        }

        else {
            System.out.println("Insufficient Account Balance!");
            return false;
        }

        System.out.println("Amount Withdrawn Successfully!");
        return true;
    }
}
