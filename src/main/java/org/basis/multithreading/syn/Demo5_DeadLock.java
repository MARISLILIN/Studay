package org.basis.multithreading.syn;

public class Demo5_DeadLock {
    private static String s1 = "筷子左";
    private static String s2 = "筷子右";
    public static void main(String[] args) {
    new Thread() {
      @Override
      public void run() {
        synchronized (s1) {
          while (true) {
            System.out.println(getName() + "获取" + s1 + "等待" + s2);
            synchronized (s2) {
                System.out.println(getName() + "拿到" + s2 + "开吃");
            }
          }
        }
      }
    }.start();
    new Thread() {
      @Override
      public void run() {
        synchronized (s2) {
          while (true) {
            System.out.println(getName() + "获取" + s2 + "等待" + s1);
            synchronized (s1) {
                System.out.println(getName() + "拿到" + s1 + "开吃");
            }
          }
        }
      }
    }.start();
  }
}
