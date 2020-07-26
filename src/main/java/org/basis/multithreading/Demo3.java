package org.basis.multithreading;

public class Demo3 {
  public static void main(String[] args) {
      new Thread() {
          @Override
          public void run() {
              for (int i = 0; i < 1000; i++) {
                  System.out.println("aaaaaaaaaaaaa");
              }
          }
      }.start();

      new Thread(new Runnable() {
          @Override
          public void run() {
              for (int i = 0; i < 1000; i++){
                  System.out.println("bbbbbbb");
              }
          }
      }).start();
  }
}
