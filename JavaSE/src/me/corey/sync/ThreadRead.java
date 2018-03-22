package me.corey.sync;

public class ThreadRead implements Runnable {
    SyncDemo syncDemo;

    ThreadRead(SyncDemo syncDemo) {
        this.syncDemo = syncDemo;
    }

    @Override
    public void run() {
        synchronized (syncDemo) {
            while (true){
                if (syncDemo.readFlag()) {
                    System.out.println(Thread.currentThread() + ":readFlag success" + syncDemo.readFlag());
                    break;
                } else {
                    try {
                        System.out.println(Thread.currentThread() + ":readFlag failed" + syncDemo.readFlag());
                        syncDemo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
    }

}
