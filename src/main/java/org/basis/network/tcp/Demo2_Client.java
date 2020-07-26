package org.basis.network.tcp;

import java.io.*;
import java.net.Socket;

public class Demo2_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 12345);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());

        System.out.println(br.readLine());
        ps.println("hello");
        System.out.println(br.readLine());
        ps.println("i know");
        socket.close();
    }
}
