package me.corey.sync.example.bank_05_rwlock;

public class Test {

    public static final int numOfAccounts = 100;
    public static final double initBalance = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(numOfAccounts, initBalance);
        int i;
        for (i = 0; i < numOfAccounts; i++) {
            new Thread(new TransferRunnable(bank, i, initBalance)).start();
        }
    }
}
