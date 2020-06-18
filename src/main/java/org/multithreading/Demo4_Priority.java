package org.multithreading;

public class Demo4_Priority {
  public static void main(String[] args) {
    Thread t1 =
        new Thread() {
          @Override
          public void run() {
            for (int i = 0; i < 100; i++) {
              System.out.println(getName() + "..aaaaaaaaaaaaa");
            }
          }
        };
      Thread t2 =
              new Thread() {
                  @Override
                  public void run() {
                      for (int i = 0; i < 100; i++) {
                          System.out.println(getName() + "..b");
                      }
                  }
              };

      t1.setPriority(Thread.MIN_PRIORITY);
      t2.setPriority(Thread.MIN_PRIORITY);
      t1.start();
      t2.start();
  }
}
