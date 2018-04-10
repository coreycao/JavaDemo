package me.corey.sync.example.bank_03_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;

    private Lock bankLock;

    private Condition sufficientFunds;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < n; i++) {
            accounts[i] = initialBalance;
        }
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount) {
//        if (accounts[from] < amount) return;
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d ", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            bankLock.unlock();
        }

    }

    private double getTotalBalance() {
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
