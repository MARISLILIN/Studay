package org.network.socket;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo4_GUIChat extends Frame {

    TextField tf;
    Button send;
    Button log;
    Button clear;
    Button shake;

    TextArea viewText;
    TextArea sendText;


    DatagramSocket socket;

    BufferedWriter bw;

    public Demo4_GUIChat() {
        init();
        southPanel();
        centerPanel();
        event();
    }

    private void event() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    socket.close();
                    bw.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }
        });

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    send();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    logFile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewText.setText("");
            }
        });

        shake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    send(new byte[]{-1}, tf.getText());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        sendText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {
                    try {
                        send();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

    }

    private void shake() {
        int x = this.getLocation().x;
        int y = this.getLocation().y;

        for (int i = 0; i < 5; i++) {
            try {
                this.setLocation(x + 20, y + 20);
                Thread.sleep(30);
                this.setLocation(x + 20, y - 20);
                Thread.sleep(30);
                this.setLocation(x - 20, y + 20);
                Thread.sleep(30);
                this.setLocation(x - 20, y - 20);
                Thread.sleep(30);
                this.setLocation(x , y );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void logFile() throws IOException {
        bw.flush();
        FileInputStream fis = new FileInputStream("config.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int len;
        byte[] arr = new byte[8192];
        while ((len = fis.read(arr)) != -1) {
            baos.write(arr, 0, len);
        }
        String str = baos.toString();
        viewText.setText(str);
        fis.close();
    }
    private void send(byte[] arr, String ip) throws IOException {
        DatagramPacket packet =
                new DatagramPacket(arr, arr.length, InetAddress.getByName(ip), 9999);
        socket.send(packet);
    }
    private void send() throws IOException {
        String message = sendText.getText();
        String ip = tf.getText();
        ip = ip.trim().length() == 0 ? "255.255.255.255" : ip;

        send(message.getBytes(), ip);

        String time = getcurrentTime();
        String str = time + "我对:" + ("255.255.255.255".equals(ip) ? "所有人" : ip) + "说:\r\n" + message + "\r\n\r\n";
        viewText.append(str);
        bw.write(str);
        sendText.setText("");

    }

    private String getcurrentTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return sdf.format(d);
    }

    private void centerPanel() {
        Panel center = new Panel();
        //显示
        viewText = new TextArea();
        //发送
        sendText = new TextArea(5,1);
        //设置为边界布局
        center.setLayout(new BorderLayout());
        center.add(sendText,BorderLayout.SOUTH);
        center.add(viewText,BorderLayout.CENTER);
        //设置无法编辑
        viewText.setEditable(false);
        //设置背景色
        viewText.setBackground(Color.WHITE);
        sendText.setFont(new Font("xxx", Font.PLAIN, 15));
        viewText.setFont(new Font("xxx", Font.PLAIN, 15));
        this.add(center,BorderLayout.CENTER);

    }

    private void southPanel() {
        Panel south = new Panel();
        //ip
        tf = new TextField(15);
        tf.setText("127.0.0.1");
        //发送
        send = new Button("发送");
        //记录
        log = new Button("记录");
        //清屏
        clear = new Button("清屏");
        //震动
        shake = new Button("震动");

        south.add(tf);
        south.add(send);
        south.add(log);
        south.add(clear);
        south.add(shake);
        this.add(south,BorderLayout.SOUTH);
    }

    public void init() {
        this.setLocation(500,50);
        this.setSize(400,600);
        new Receive().start();

        try {
            socket = new DatagramSocket();
            bw = new BufferedWriter(new FileWriter("config.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setVisible(true);
    }

    private class Receive extends Thread {
        @Override
        public void run() {
            try {
                DatagramSocket socket = new DatagramSocket(9999);
                DatagramPacket packet = new DatagramPacket(new byte[8192], 8192);

                while (true) {
                    socket.receive(packet);
                    byte[] arr = packet.getData();
                    int len = packet.getLength();
                    if (arr[0] == -1 && len == 1) {
                        shake();
                        continue;
                    }

                    String message = new String(arr, 0, len);

                    String time = getcurrentTime();
                    String ip = packet.getAddress().getHostAddress();
                    String str = time + " " + ip + "对我说:\r\n" + message + "\r\n\r\n";
                    viewText.append(str);
                    bw.write(str);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        new Demo4_GUIChat();
    }
}
