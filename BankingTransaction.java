
import java.util.Scanner;

class Account {

    private int bal, newbal;

    public Account(int b) {
        bal = b;
    }

    synchronized public int getBalance() {
        return bal;
    }

    synchronized public void withdraw(int w) {
        int b = getBalance();
        {
            if (w <= b) {
                bal = bal - w;
                newbal = bal;
            } else {
                System.out.println("NOT ENOUGH BALANCE\n" + Thread.currentThread().getName() + " cannot withdraw money");
                System.exit(0);
            }
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

public class BankingTransaction {

    static int n;

    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //System.out.println("Enter maximum no. of withdrawals allowed!!!");
        //n = scan.nextInt();
        Account a1 = new Account(1000);
        Withdrawal w = new Withdrawal(a1, 80);
        Thread m1 = new Thread(w);
        m1.setName("Trans1");

        Thread m2 = new Thread(w);
        m2.setName("Trans2");

        m1.start();
        m2.start();
    }
}
