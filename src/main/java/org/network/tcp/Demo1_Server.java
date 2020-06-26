package org.network.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1_Server {
  public static void main(String[] args) throws IOException {
      ServerSocket server = new ServerSocket(12345);

      Socket socket = server.accept();
      InputStream is = socket.getInputStream();
      OutputStream os = socket.getOutputStream();

      os.write("百度一下你就知道".getBytes());

      byte[] arr = new byte[1024];
      int len = is.read(arr);

      System.out.println(new String(arr, 0, len));

      socket.close();

  }
}
