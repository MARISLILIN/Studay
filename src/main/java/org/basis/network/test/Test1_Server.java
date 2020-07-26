package org.basis.network.test;

import org.apache.commons.lang.text.StrBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test1_Server {
  public static void main(String[] args) throws IOException {
    //
    ServerSocket server = new ServerSocket(54321);
    System.out.println("sewrver started, port : 54321");

    while (true) {
      final Socket socket = server.accept();

      new Thread() {
        @Override
        public void run() {
          try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream ps = new PrintStream(socket.getOutputStream());

            String line = br.readLine();
            line = new StrBuilder(line).reverse().toString();
            ps.println(line);

            socket.close();
          } catch (IOException e) {
            e.printStackTrace();
          }

        }
      }.start();
    }

  }
}
