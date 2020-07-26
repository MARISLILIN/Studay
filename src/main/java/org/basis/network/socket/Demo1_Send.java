package org.basis.network.socket;

import java.io.IOException;
import java.net.*;

public class Demo1_Send {
    public static void main(String[] args) throws IOException {
        String str = "asdasdfjkhkwhe";
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);

        socket.send(packet);

        socket.close();

    }
}
