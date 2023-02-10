public class Person {
    private String personName;
    private int personId;
    private String personAddress;
    private int numberOfAccounts;

    public Person(String name, int id, String address) {
        this.personName = name;
        this.personId = id;
        this.personAddress = address;
        numberOfAccounts = 0;
    }

    public void setPersonName(String name) {
        this.personName = name;
    }

    public void setPersonId(int id) {
        this.personId = id;
    }

    public void setPersonAddress(String address) {
        this.personAddress = address;
    }

    public void incrementNumberOfAccounts() {
        numberOfAccounts++;
    }

    public int getPersonId() {
        return personId;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public String getPersonName() {
        return personName;
    }

    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    @Override
    public String toString() {

        String details;
        details = "Account Holder Name : " + this.personName + "\n" + "Account Holder ID : " +
                  Integer.toString(this.personId) + "\n" + "Account Holder Address : " + this.personAddress + "\n";

        return details;
    }

}
