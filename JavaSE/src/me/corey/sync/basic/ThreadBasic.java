package me.corey.sync.basic;

public class ThreadBasic {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("hello");
        });

        thread.start();
    }
}
