package Banking;

public class Account {
    private double balance;

    public Account(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public boolean deposit(double amount){
        if(amount > 0){
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }

    //  FIX: transfer
    public boolean transfer(Account target, double amount){
        if(this.withdraw(amount)){
            target.deposit(amount);
            return true;
        }
        return false;
    }
}
