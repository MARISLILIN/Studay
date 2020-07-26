package org.basis.multithreading;

public class Demo2 {
  public static void main(String[] args) {
      MyRunnable mr = new MyRunnable();
      Thread t = new Thread(mr);
      t.start();

      for (int i = 0; i < 1000; i++){
          System.out.println("bbbbbbb");
      }
  }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("aaaaaaaaaaaaa");
        }
    }
}