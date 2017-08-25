package com.corey.pattern.adapter;

public class SocketAdapter implements DBSocket {

    private GBSocket gbSocket;

    SocketAdapter(GBSocket gbSocket) {
        this.gbSocket = gbSocket;
    }

    @Override
    public void powerWithTwoFlat() {
        gbSocket.powerWithThreeFlat();
    }
}
