package me.corey.sync.example.bank_05_rwlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Bank {
    private final double[] accounts;

    private ReentrantReadWriteLock rwlock;

    private Lock readLock;

    private Lock writeLock;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < n; i++) {
            accounts[i] = initialBalance;
        }
        rwlock = new ReentrantReadWriteLock();
        readLock = rwlock.readLock();
        writeLock = rwlock.writeLock();
    }

    public void transfer(int from, int to, double amount) {
        writeLock.lock();
        try {
            if (accounts[from] < amount) return;
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d ", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total balance: %10.2f%n", getTotalBalance());
        } finally {
            writeLock.unlock();
        }
    }

    private double getTotalBalance() {
        readLock.lock();
        try {
            double sum = 0;
            for (double d : accounts) {
                sum += d;
            }
            return sum;
        } finally {
            readLock.unlock();
        }
    }

    public int size() {
        return accounts.length;
    }
}
