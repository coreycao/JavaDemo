package me.corey.sync.example.bank_02_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 Lock 对 transfer 进行同步
 */
public class Bank {
    private final double[] accounts;

    private Lock lock;

    public Bank(int n, double initialBalance) {
        // 可重入锁，接受一个boolean，表示是否公平
        lock = new ReentrantLock();
        accounts = new double[n];
        for (int i = 0; i < n; i++) {
            accounts[i] = initialBalance;
        }
    }

    public void transfer(int from, int to, double amount) {
        lock.lock();
        try {
            if (accounts[from] < amount) return;
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d ", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total balance: %10.2f%n", getTotalBalance());
        } finally {
            lock.unlock();
        }
    }

    private double getTotalBalance() {
        try {
            lock.lock();
            double sum = 0;
            for (double d : accounts) {
                sum += d;
            }
            return sum;
        } finally {
            lock.unlock();
        }

    }

    public int size() {
        return accounts.length;
    }
}
