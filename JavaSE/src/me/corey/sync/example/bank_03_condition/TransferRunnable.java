package me.corey.sync.example.bank_03_condition;

public class TransferRunnable implements Runnable {
    private Bank bank;

    private int fromAccount;

    private double maxAmount;

    private int DELAY = 10;

    public TransferRunnable(Bank b, int fromAccount, double maxAmount) {
        this.bank = b;
        this.fromAccount = fromAccount;
        this.maxAmount = maxAmount;
    }


    @Override
    public void run() {
        try {
            while (true) {
                int toAccount = (int) (bank.size() * Math.random());
                double amount = maxAmount * Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
