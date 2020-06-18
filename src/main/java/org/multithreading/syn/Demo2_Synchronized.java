package org.multithreading.syn;

public class Demo2_Synchronized {
  public static void main(String[] args) {
    final Printer2 p1 = new Printer2();
    new Thread() {
      @Override
      public void run() {
        while (true) {
          p1.print1();
        }
      }
    }.start();
    new Thread() {
      @Override
      public void run() {
        while (true) {
          p1.print2();
        }
      }
    }.start();
  }
}

class Printer2 {
  //非静态的同步方法的锁对象是this
  //静态同步方法的锁对象是该类的字节码对象
    public synchronized void print1() {
      System.out.print("a");
      System.out.print("b");
      System.out.print("c");
      System.out.print("d");
      System.out.print("\r\n");

  }
    public void print2() {
    synchronized (Printer2.class) {
      System.out.print("A");
      System.out.print("B");
      System.out.print("C");
      System.out.print("D");
      System.out.print("\r\n");
      }

  }
}
