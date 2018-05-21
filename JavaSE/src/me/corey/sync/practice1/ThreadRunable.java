package me.corey.sync.practice1;

public class ThreadRunable implements Runnable {

    private String num;

    private final Object lock = new Object();

    ThreadRunable(String num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                System.out.print(num + " ");
                try {
                    lock.notifyAll();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
