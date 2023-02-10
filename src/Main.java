public class Main {


    public static void main(String[] args) {

        String [] names = {"Muhammad Ali", "Junaid Khalid", "Rayyan Attaullah", "Muhammad Mujtaba", "Adnan Khattak"};

        int [] ids = {1170,1142,1161,2064,1141};

        String [] addresses = {"Islamabad", "Lahore", "Peshawar", "Multan", "Quetta"};

        Person person1 = new Person(names[0],ids[0],addresses[0]);
        Person person2 = new Person(names[1],ids[1],addresses[1]);
        Person person3 = new Person(names[2],ids[2],addresses[2]);
        Person person4 = new Person(names[3],ids[3],addresses[3]);
        Person person5 = new Person(names[4],ids[4],addresses[4]);

        Bank bank = new Bank();

        bank.openAccount(person1);
        bank.openAccount(person2);
        bank.openAccount(person3);
        bank.openAccount(person4);
        bank.openAccount(person5);

        bank.depositAmount(person1, 1000);
        bank.depositAmount(person2, 2000);
        bank.depositAmount(person3, 1500);
        bank.depositAmount(person4, 3000);
        bank.depositAmount(person5, 5000);

        bank.withdrawAmount(person1, 200);
        bank.withdrawAmount(person2, 100);
        bank.withdrawAmount(person3, 1600);
        bank.withdrawAmount(person4, 800);
        bank.withdrawAmount(person5, 1000);

        bank.closeAccount(person4);

        bank.showAllAccounts();
    }
}