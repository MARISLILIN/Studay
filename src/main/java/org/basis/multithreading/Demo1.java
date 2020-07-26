package org.basis.multithreading;

public class Demo1 {
  public static void main(String[] args) {
    //
      MyThread mt = new MyThread();
      mt.start();

    for (int i = 0; i < 1000; i++){
      System.out.println("bbbbbbb");
    }
  }
}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("aaaaaaaaaaaaa");
        }
    }
}
