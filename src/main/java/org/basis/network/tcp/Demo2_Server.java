package org.basis.network.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo2_Server {
  public static void main(String[] args) throws IOException {
      //demo1();
      ServerSocket server = new ServerSocket(12345);

      while (true) {
          final Socket socket = server.accept();
          new Thread() {
              @Override
              public void run() {
                  try {
                      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                      PrintStream ps = new PrintStream(socket.getOutputStream());

                      ps.println("欢迎访问aaaaaaaaaaaa");
                      System.out.println(br.readLine());
                      ps.println("sorry");
                      System.out.println(br.readLine());
                      socket.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          }.start();
      }
  }

    public static void demo1() throws IOException {
        ServerSocket server = new ServerSocket(12345);

        Socket socket = server.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());

        ps.println("欢迎访问aaaaaaaaaaaa");
        System.out.println(br.readLine());
        ps.println("sorry");
        System.out.println(br.readLine());
        socket.close();
    }
}
