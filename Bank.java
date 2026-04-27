package Banking;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers = new ArrayList<>();
    private String bankName;

    public Bank(String bankName){
        this.bankName = bankName;
    }

    public void addCustomer(String f, String l){
        customers.add(new Customer(f, l));
    }

    public Customer getCustomer(int index){
        return customers.get(index);
    }

    public int getNumberOfCustomers(){
        return customers.size();
    }

    //  FIX: find customer
    public Customer findCustomerByFirstName(String name){
        for(Customer c : customers){
            if(c.getFirstName().equalsIgnoreCase(name)){
                return c;
            }
        }
        return null;
    }

    //  FIX: delete customer
    public boolean deleteCustomer(String name){
        Customer c = findCustomerByFirstName(name);
        if(c != null){
            customers.remove(c);
            return true;
        }
        return false;
    }

    //  FIX: display customers
    public void displayCustomers(){
        if(customers.isEmpty()){
            System.out.println("No customers.");
            return;
        }

        for(Customer c : customers){
            System.out.println(c.getFirstName() + " " + c.getLastName());
        }
    }
}
