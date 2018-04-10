package me.corey.sync.example.bank_04_sync;

public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < n; i++) {
            accounts[i] = initialBalance;
        }
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from]<amount){
            wait();
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d ", amount, from, to);
        accounts[to] += amount;
        System.out.printf("Total balance: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    private synchronized double getTotalBalance() {
        double sum = 0;
        for (double d : accounts) {
            sum += d;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
