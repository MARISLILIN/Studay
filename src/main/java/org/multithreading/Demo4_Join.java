package org.multithreading;

public class Demo4_Join {
  public static void main(String[] args) {
    final Thread t1 =
        new Thread() {
          @Override
          public void run() {
            for (int i = 0; i < 10; i++) {
              System.out.println(getName() + ".......aaaaaaaaa");
            }
          }
        };
    Thread t2 =
      new Thread() {
          @Override
          public void run() {
              for (int i = 0; i < 10; i++) {
                  if (i == 2) {
                      try {
                          t1.join();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
                  System.out.println(getName() + ".......bbbb");
              }
          }
      };


    t1.start();
    t2.start();
  }
}
