import java.util.Scanner;

public class Main {
    
    public static void main(String [] args) {

        // inserting some random users in bank system.

        String [] names = {"Muhammad Ali", "Junaid Khalid", "Rayyan Attaullah", "Muhammad Mujtaba", "Adnan Khattak"};

        int [] ids = {1170,1142,1161,2064,1141};

        String [] addresses = {"Islamabad", "Lahore", "Peshawar", "Multan", "Quetta"};

        Person person1 = new Person(names[0],ids[0],addresses[0]);
        Person person2 = new Person(names[1],ids[1],addresses[1]);
        Person person3 = new Person(names[2],ids[2],addresses[2]);
        Person person4 = new Person(names[3],ids[3],addresses[3]);
        Person person5 = new Person(names[4],ids[4],addresses[4]);

        Bank bank = new Bank();

        bank.openAccount(person1,"Current");
        bank.openAccount(person2,"Current");
        bank.openAccount(person3,"Saving");
        bank.openAccount(person4,"Saving");
        bank.openAccount(person5,"Saving");

        bank.depositAmount(ids[0], 1000);
        bank.depositAmount(ids[1], 2000);
        bank.depositAmount(ids[2], 1500);
        bank.depositAmount(ids[3], 3000);
        bank.depositAmount(ids[4], 5000);

        bank.withdrawAmount(ids[0], 200);
        bank.withdrawAmount(ids[1], 100);
        bank.withdrawAmount(ids[2], 1600);
        bank.withdrawAmount(ids[3], 800);
        bank.withdrawAmount(ids[4], 1000);

        System.out.println();
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        System.out.println("*********Welcome to SDA Financials Ltd***********");

        do {

            System.out.println("1. Open Account");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Depost Amount");
            System.out.println("4. Close Account");
            System.out.println("5. Show Bank Statement");
            System.out.println("*** Enter -99 to exit***");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {

                case 1:
                
                String name;
                int id;
                String address;
                int accountType;

                System.out.println("Enter Your Name");
                name = scanner.nextLine();

                System.out.println("Enter ID");
                id = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter Address");
                address = scanner.nextLine();

                Person person = new Person(name, id, address);

                System.out.println("Enter Account Type\n\n1.Saving\n2.Current\n3.Joint");
                accountType = scanner.nextInt();
                scanner.nextLine();

                switch(accountType) {

                    case 1:
                    bank.openAccount(person, "Saving");
                    break;

                    case 2:
                    bank.openAccount(person, "Current");
                    break;

                    case 3:

                    System.out.println("Enter Name of 2nd Person");
                    name = scanner.nextLine();

                    System.out.println("Enter ID of 2nd Person");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Address of 2nd Person");
                    address = scanner.nextLine();

                    Person person_2 = new Person(name, id, address);

                    bank.openAccount(person, person_2, "Joint");
                    break;

                } break;

                case 2:
                int accountId = 0;
                double amount = 0.0f;

                System.out.println("Enter your ID");
                accountId = scanner.nextInt();

                System.out.println("Enter Amount");
                amount = scanner.nextDouble();

                bank.withdrawAmount(accountId, amount);
                break;

                case 3:
                int Id = 0;
                double Amount = 0.0f;

                System.out.println("Enter your ID");
                Id = scanner.nextInt();

                System.out.println("Enter Amount");
                Amount = scanner.nextDouble();

                bank.depositAmount(Id, Amount);
                break;

                case 4:

                int AccountId = 0;

                System.out.println("Enter your ID");
                AccountId = scanner.nextInt();

                bank.closeAccount(AccountId);
                break;

                case 5:

                System.out.println("Enter your ID");
                AccountId = scanner.nextInt();

                bank.showBankStatement(AccountId);
                break;

            }

        } while(choice != -99);

        bank.showAllAccounts();
        System.out.println();
        bank.showAllTranscations();

    }
}
