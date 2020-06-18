package org.multithreading;

public class Demo4_Name {
  public static void main(String[] args) {
      //demo1();
      Thread t1 = new Thread() {
          @Override
          public void run() {
              //this.setName("张三");
              System.out.println(this.getName() + "aaaaaaaaaa");
          }
      };

      Thread t2 = new Thread() {
          @Override
          public void run() {
              //this.setName("李四");
              System.out.println(this.getName() + "bbbbbbb");
          }
      };
      t1.setName("张三");
      t2.setName("李四");
      t1.start();
      t2.start();


  }

    public static void demo1() {
        new Thread("AAAA") {
            @Override
            public void run() {
                System.out.println(this.getName() + "aaaaaaaaaa");
            }
        }.start();

        new Thread("BBBB") {
            @Override
            public void run() {
                System.out.println(this.getName() + "bbbbbbb");
            }
        }.start();
    }
}
