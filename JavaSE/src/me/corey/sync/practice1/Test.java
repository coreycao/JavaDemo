package me.corey.sync.practice1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
//        new Thread(new ThreadRunable("0")).start();
//        new Thread(new ThreadRunable("1")).start();

        Thread t3 = new Thread(new PrintRunnableByLock<Integer>(3, true));
        Thread t4 = new Thread(new PrintRunnableByLock<Integer>(4, false));
        t3.start();
        t4.start();
    }

    private static final class PrintRunnableByLock<T> implements Runnable {

        private T t;
        private static final int MAX_COUNT = 10;

        private static final ReentrantLock LOCK = new ReentrantLock();
        private static final Condition FIRST_CONDITION = LOCK.newCondition();
        private static final Condition SECOND_CONDITION = LOCK.newCondition();

        private final boolean first;

        public PrintRunnableByLock(T t, boolean first) {
            this.t = t;
            this.first = first;
        }

        @Override
        public void run() {
            LOCK.lock();
            try {
                for (int i = 0; i < MAX_COUNT; i++) {
                    System.out.print(t.toString() + " ");
                    if (this.first) {
                        this.notifySecond();
                    } else {
                        this.notifyFirst();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }

        private void notifySecond() throws InterruptedException {
            SECOND_CONDITION.signal();
            FIRST_CONDITION.await();
        }

        private void notifyFirst() throws InterruptedException {
            FIRST_CONDITION.signal();
            SECOND_CONDITION.await();
        }

    }
}
