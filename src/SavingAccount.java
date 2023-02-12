public class SavingAccount extends Account{

    public SavingAccount(Person person, double balance,String accountType) {
        super(person, balance,accountType);
    }
    
    public boolean withdrawAmount(double amount) {

        if(this.accountBalance > amount) {
            
            double penalty = amount * 0.01;
            this.accountBalance = (this.accountBalance - amount) - penalty;
        }

        else {
            System.out.println("Insufficient Account Balance!");
            return false;
        }
        
        System.out.println("Amount Withdrawn Successfully!");
        return true;
    }
}
