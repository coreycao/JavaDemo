package com.corey.pattern.adapter;

public class Hotel {

    private DBSocket dbSocket;

    public void setDbSocket(DBSocket dbSocket) {
        this.dbSocket = dbSocket;
    }

    public void charge() {
        if (dbSocket != null) {
            dbSocket.powerWithTwoFlat();
        } else {
            System.out.printf("no socket");
        }
    }
}
