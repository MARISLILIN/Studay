package org.network.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Demo3_MoreThread {
    public static void main(String[] args) {
        new Receive().start();
        new Send().start();
    }
}

class Receive extends Thread {
    @Override
    public void run() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(6666);
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

            while (true) {
                socket.receive(packet);
                byte[] arr = packet.getData();
                int len = packet.getLength();
                String ip = packet.getAddress().getHostAddress();
                int port = packet.getPort();
                System.out.println(ip + ":" + port + ":" + new String(arr,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Send extends Thread {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            while (true) {
                String line = sc.nextLine();
                if ("quit".equals(line)) {
                    break;
                }
                DatagramPacket packet =
                        new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
                socket.send(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}