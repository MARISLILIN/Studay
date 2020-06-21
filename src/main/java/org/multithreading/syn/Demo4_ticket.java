package org.multithreading.syn;

public class Demo4_ticket {
  public static void main(String[] args) {
      /*MyTicket mt = new MyTicket();
      new Thread(mt).start();
      new Thread(mt).start();
      new Thread(mt).start();
      new Thread(mt).start();*/


  }
}

class MyTicket implements Runnable {
    private static int tickets = 100;
    @Override
    public void run() {
        while (true) {
            synchronized (MyTicket.class) {
                if (tickets <= 0) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "...这是第" + tickets-- + "号票");
            }
        }
    }
}
