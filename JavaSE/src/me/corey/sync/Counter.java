package me.corey.sync;

public class Counter implements Runnable {

    private int count;

    public Counter() {
        this.count = 0;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("A")) {
            addCount();
        } else if (threadName.equals("B")) {
            printCount();
        }

    }

    private synchronized void addCount() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void printCount() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " count:" + count);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
