
import java.util.Scanner;

class Account {

    private int bal, newbal;
    private int wlimit = 10, wcount=0;

    public Account(int b) {
        bal = b;
    }

    synchronized public int getBalance() {
        return bal;
    }

    synchronized public void withdraw(int w) {
        int b = getBalance();
        if(wcount <= wlimit){
            if (w <= b) {
                bal = bal - w;
                newbal = bal;
                wcount++;
            } else {
                System.out.println("NOT ENOUGH BALANCE\n\t " + 
                        Thread.currentThread().getName() + " cannot withdraw money");
                System.exit(0);
            }
        }
        else {
            System.out.println("Withdrawal limit reached (" + wcount + ") " +
                    Thread.currentThread().getName()+
                    " cannot withdraw money\n\ttry again later");
            System.exit(0);
        }
    }
}

class Withdrawal implements Runnable {

    private Account acc;
    private int amount;

    public Withdrawal() {
        acc = null;
        amount = 0;
    }

    public Withdrawal(Account acc, int amount) {
        this.acc = acc;
        this.amount = amount;
    }

    public void run() {
        int w;

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Balance before " + Thread.currentThread().getName() + " withdraw: " + acc.getBalance());
            acc.withdraw(amount);
            System.out.println("Balance after " + Thread.currentThread().getName() + " withdraw: " + acc.getBalance());

        }
    }
}

public class BankingMonitor {

    static int n;

    public static void main(String[] args) {
        Account a1 = new Account(1000);
        Withdrawal w = new Withdrawal(a1, 85);
        Thread m1 = new Thread(w);
        m1.setName("Transaction A");

        Thread m2 = new Thread(w);
        m2.setName("Transaction B");

        m1.start();
        m2.start();
    }
}
