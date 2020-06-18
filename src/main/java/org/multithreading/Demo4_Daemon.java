package org.multithreading;

public class Demo4_Daemon {
  public static void main(String[] args) {
      Thread t1 = new Thread() {
          @Override
          public void run() {
              for (int i = 0; i < 2; i++) {
                  System.out.println(this.getName()+".....aaaaaaaaaaaaa");
              }
          }
      };

      Thread t2 = new Thread() {
          @Override
          public void run() {
              for (int i = 0; i < 50; i++) {
                  System.out.println(this.getName()+"......bbbbbbbbbbbbb");
              }
          }
      };

      t2.setDaemon(true);
      t1.start();
      t2.start();

  }
}
