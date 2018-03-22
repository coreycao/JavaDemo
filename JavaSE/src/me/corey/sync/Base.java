package me.corey.sync;

public class Base {
    public static void main(String[] args) {
     /*   Counter counter = new Counter();
        Thread threadA = new Thread(counter, "A");
        Thread threadB = new Thread(counter, "B");
        threadA.start();
        threadB.start();*/

        SyncDemo syncDemo = new SyncDemo();

        new Thread(new ThreadRead(syncDemo), "read").start();
        new Thread(new ThreadWrite(syncDemo), "write").start();
    }
}
