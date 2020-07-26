package org.basis.designpatterns.thread;

public class Demo1_Notify {
  public static void main(String[] args) {
    final Printer p = new Printer();

    new Thread() {
      @Override
      public void run() {
        while (true) {
          try {
            p.print1();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();
    new Thread() {
      @Override
      public void run() {
        while (true) {
          try {
            p.print2();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();
  }
}

class Printer {
    private int flag = 1;
    public void print1() throws InterruptedException {
      synchronized (this) {
        if (flag != 1) {
          this.wait();
        }
        System.out.print("a");
        System.out.print("b");
        System.out.print("c");
        System.out.print("d");
        System.out.print("\r\n");
        flag = 2;
        this.notify();
        }

  }
    public void print2() throws InterruptedException {
      synchronized (this) {
        if (flag != 2) {
          this.wait();
        }
        System.out.print("A");
        System.out.print("B");
        System.out.print("C");
        System.out.print("D");
        System.out.print("\r\n");
        flag = 1;
        this.notify();
        }

  }
}
