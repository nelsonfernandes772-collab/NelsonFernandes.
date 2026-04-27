package Banking;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Account getAccount(){
        return account;
    }

    public void setAccount(Account account){
        this.account = account;
    }

    // ✅ FIX: display info
    public void displayCustomer(){
        System.out.println("Name: " + firstName + " " + lastName);

        if(account != null){
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("No account yet.");
        }
    }
}
