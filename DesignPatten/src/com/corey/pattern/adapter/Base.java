package com.corey.pattern.adapter;

public class Base {
    public static void main(String[] args) {
        DBSocket dbSocket = new DBSocketImpl();
        Hotel hotel = new Hotel();
        hotel.setDbSocket(dbSocket);
        hotel.charge();

        System.out.println("---------");

        SocketAdapter socketAdapter = new SocketAdapter(new GBSocketImpl());
        hotel.setDbSocket(socketAdapter);
        hotel.charge();
    }
}
