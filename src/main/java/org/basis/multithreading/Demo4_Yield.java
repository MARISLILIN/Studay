package org.basis.multithreading;

public class Demo4_Yield {
  public static void main(String[] args) {
    new MyThread2().start();
    new MyThread2().start();
  }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
          if (1 % 10 == 0) {
              Thread.yield();
          }
          System.out.println(getName()+ "...." + i);
        }
    }
}