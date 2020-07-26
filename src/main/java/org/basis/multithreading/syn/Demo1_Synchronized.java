package org.basis.multithreading.syn;

public class Demo1_Synchronized {
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

class  Printer {
  Object o = new Object();
    public void print1() {
      synchronized (o) {
      System.out.print("a");
      System.out.print("b");
      System.out.print("c");
      System.out.print("d");
      System.out.print("\r\n");
      }
  }
    public void print2() {
      synchronized (o) {
      System.out.print("A");
      System.out.print("B");
      System.out.print("C");
      System.out.print("D");
      System.out.print("\r\n");
      }
  }
}
