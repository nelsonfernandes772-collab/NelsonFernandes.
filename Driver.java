package Banking;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank("Banku Ku");

        boolean running = true;

        while(running){
            System.out.println("\n=== BANK SYSTEM ===");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // FIX

            // ================= ADMIN =================
            if(choice == 1){
                boolean adminMenu = true;

                while(adminMenu){
                    System.out.println("\n--- ADMIN MENU ---");
                    System.out.println("1. Add Customer");
                    System.out.println("2. Search Customer");
                    System.out.println("3. Delete Customer");
                    System.out.println("4. Display Customers");
                    System.out.println("5. Create Account");
                    System.out.println("6. Back");
                    System.out.print("Choose: ");

                    int adminChoice = sc.nextInt();
                    sc.nextLine(); // FIX

                    if(adminChoice == 1){
                        System.out.print("First Name: ");
                        String f = sc.nextLine();
                        System.out.print("Last Name: ");
                        String l = sc.nextLine();
                        bank.addCustomer(f, l);
                        System.out.println("Customer added!");

                    } else if(adminChoice == 2){
                        System.out.print("Enter First Name: ");
                        String name = sc.nextLine();
                        Customer c = bank.findCustomerByFirstName(name);

                        if(c != null){
                            c.displayCustomer();
                        } else {
                            System.out.println("Customer not found.");
                        }

                    } else if(adminChoice == 3){
                        System.out.print("Enter First Name to delete: ");
                        String name = sc.nextLine();

                        if(bank.deleteCustomer(name)){
                            System.out.println("Deleted successfully.");
                        } else {
                            System.out.println("Customer not found.");
                        }

                    } else if(adminChoice == 4){
                        bank.displayCustomers();

                    } else if(adminChoice == 5){
                        System.out.print("Enter First Name: ");
                        String name = sc.nextLine();
                        Customer c = bank.findCustomerByFirstName(name);

                        if(c != null){
                            System.out.print("Initial Balance: ");
                            double bal = sc.nextDouble();
                            sc.nextLine(); // FIX
                            c.setAccount(new Account(bal));
                            System.out.println("Account created!");
                        } else {
                            System.out.println("Customer not found.");
                        }

                    } else if(adminChoice == 6){
                        adminMenu = false;
                    }
                }
            }

            // ================= CUSTOMER =================
            else if(choice == 2){
                System.out.print("Enter your First Name: ");
                String name = sc.nextLine();

                Customer c = bank.findCustomerByFirstName(name);

                if(c == null || c.getAccount() == null){
                    System.out.println("Customer or account not found.");
                    continue;
                }

                boolean customerMenu = true;

                while(customerMenu){
                    System.out.println("\n--- CUSTOMER MENU ---");
                    System.out.println("1. Balance Inquiry");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Transfer");
                    System.out.println("5. Back");
                    System.out.print("Choose: ");

                    int custChoice = sc.nextInt();
                    sc.nextLine(); // FIX

                    if(custChoice == 1){
                        System.out.println("Balance: " + c.getAccount().getBalance());

                    } else if(custChoice == 2){
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        sc.nextLine(); // FIX

                        if(c.getAccount().deposit(amt)){
                            System.out.println("Deposit successful.");
                        } else {
                            System.out.println("Deposit failed.");
                        }

                    } else if(custChoice == 3){
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        sc.nextLine(); // FIX

                        if(c.getAccount().withdraw(amt)){
                            System.out.println("Withdraw successful.");
                        } else {
                            System.out.println("Withdraw failed.");
                        }

                    } else if(custChoice == 4){
                        System.out.print("Transfer to (First Name): ");
                        String targetName = sc.nextLine();

                        Customer target = bank.findCustomerByFirstName(targetName);

                        if(target != null && target.getAccount() != null){
                            System.out.print("Amount: ");
                            double amt = sc.nextDouble();
                            sc.nextLine(); // FIX

                            if(c.getAccount().transfer(target.getAccount(), amt)){
                                System.out.println("Transfer successful.");
                            } else {
                                System.out.println("Transfer failed.");
                            }
                        } else {
                            System.out.println("Target not found.");
                        }

                    } else if(custChoice == 5){
                        customerMenu = false;
                    }
                }
            }

            // ================= EXIT =================
            else if(choice == 3){
                running = false;
                System.out.println("Goodbye!");
            }

            else{
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
