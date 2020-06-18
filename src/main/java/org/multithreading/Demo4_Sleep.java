package org.multithreading;

public class Demo4_Sleep {
  public static void main(String[] args) throws InterruptedException {
      //demo1();
      new Thread() {
          @Override
          public void run() {
              for (int i = 0; i < 10; i++){
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println("aaaaaaaaa");
              }
          }
      }.start();

      new Thread(new Runnable() {
          @Override
          public void run() {
              for (int i = 0; i < 10; i++){
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println("bbbbbbb");
              }
          }
      }).start();
  }

    public static void demo1() throws InterruptedException {
        for (int i = 20; i >= 0; i--) {
            Thread.sleep(1000);
          System.out.println("倒计时第" + i + "秒");
        }
    }
}
