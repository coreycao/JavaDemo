package me.corey.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) {
//        try {
//            Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13);
//            InputStream is = socket.getInputStream();
//            Scanner scanner = new Scanner(is);
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        Socket socket = new Socket();
//        SocketAddress socketAddress = new InetSocketAddress("time-A.timefreq.bldrdoc.gov", 13);
//        try {
//            socket.connect(socketAddress);
//            socket.setSoTimeout(10000);
//            InputStream is = socket.getInputStream();
//            Scanner scanner = new Scanner(is);
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            InetAddress address1 = InetAddress.getByName("time-A.timefreq.bldrdoc.gov");
            InetAddress[] address2 = InetAddress.getAllByName("google.com");
            InetAddress localAdress = InetAddress.getLocalHost();
            System.out.println(address1);
            for (InetAddress address : address2) {
                System.out.println(address);
            }
            System.out.println(localAdress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
