package me.corey.sync;

public class ThreadWrite implements Runnable {

    SyncDemo syncDemo;

    ThreadWrite(SyncDemo syncDemo) {
        this.syncDemo = syncDemo;
    }

    @Override
    public void run() {
        synchronized (syncDemo) {
            System.out.println(Thread.currentThread() + ":pre setFlag");
            syncDemo.setFlag();
            if (syncDemo.readFlag()) {
                System.out.println(Thread.currentThread() + ":setFlag success");
                syncDemo.notifyAll();
            }
        }
    }
}
