package org.network.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Test2_UpdateServer {
  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(12345);
    System.out.println("server started ,port:12345");

    while (true) {
        final Socket socket = server.accept();
        new Thread() {
            @Override
            public void run() {
                try {
                    InputStream is = socket.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    PrintStream ps = new PrintStream(socket.getOutputStream());

                    String fileName = br.readLine();

                    File dir = new File("update");
                    dir.mkdir();
                    File file = new File(dir, fileName);

                    if (file.exists()) {
                        ps.println("exists");
                        socket.close();
                        return;
                    } else {
                        ps.println("not exists");

                    }

                    FileOutputStream fos = new FileOutputStream(file);
                    byte[] arr = new byte[8192];
                    int len;

                    while ((len = is.read(arr)) != -1) {
                        fos.write(arr, 0, len);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }
  }
}
