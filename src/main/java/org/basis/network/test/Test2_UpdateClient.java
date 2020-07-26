package org.basis.network.test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Test2_UpdateClient {
  public static void main(String[] args) throws IOException {
    //
    File file = getFile();
    Socket socket = new Socket("127.0.0.1", 12345);
    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintStream ps = new PrintStream(socket.getOutputStream());
    ps.println(file.getName());
    String result = br.readLine();
    if ("exists".equals(result)) {
      System.out.println("upload file exists");
      socket.close();
      return;
    }

      FileInputStream fis = new FileInputStream(file);

      byte[] arr = new byte[8192];
      int len;

      while ((len = fis.read(arr)) != -1) {
          ps.write(arr, 0, len);
      }

      fis.close();
      socket.close();

  }

  private static File getFile() {
    Scanner sc = new Scanner(System.in);
    System.out.println("input file path:");

    while (true) {
        String line = sc.nextLine();
        File file = new File(line);
        if (!file.exists()) {
        System.out.println("not found!!");
        } else if (file.isDirectory()) {
        System.out.println("error directory path");
        } else {
            return file;
        }
    }
  }
}
