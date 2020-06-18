package org.multithreading;

public class Demo4_CurrentThread {
  public static void main(String[] args) {
      new Thread() {
          @Override
          public void run() {
              System.out.println(this.getName() + "aaaaaaaaaa");
          }
      }.start();

      new Thread (new Runnable() {
          @Override
          public void run() {
              System.out.println(Thread.currentThread().getName() + "aaaaaaaaaa");
          }
      }).start();

      Thread.currentThread().setName("wszxc");
    System.out.println(Thread.currentThread().getName());
  }
}
