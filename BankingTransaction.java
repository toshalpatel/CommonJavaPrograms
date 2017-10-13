import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SavingsAccount
{
    private double balance;
    private double interest;

    public SavingsAccount()
    {
        balance = 0;
        interest = 0;
    }

    public SavingsAccount(double initialBalance, double initialInterest)
    {
        balance = initialBalance;
        interest = initialInterest;
    }

    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    public void withdraw(double amount)
    {
        balance = balance - amount;
    }

    public void addInterest()
    {
        balance = balance + balance * interest;
    }

    public double getBalance()
    {
        return balance;
    }

}

public class BankingTransactions {
    private final Lock lock = new ReentrantLock();
    
    static int accBal=0;
    
    public void customer1(int amt) {
        lock.lock();
 
        try {
            accBal += amt;
            System.out.println("Adding $"+amt);
        } finally {
            lock.unlock();
        }
    }
 
    public int customer2(int amt) {
        lock.lock();
 
        try {
            accBal += amt;
            System.out.println("Adding $"+amt);
        } finally {
            lock.unlock();
        }
        return 0;
    }
    
    public static void main(String[] args){
        System.out.println("Banking transactions of a joint account:");
        SavingsAccount account1 = new SavingsAccount(4653.8, 8);        
        SavingsAccount account2 = new SavingsAccount(4765.8, 8);
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        
        
    }
}
