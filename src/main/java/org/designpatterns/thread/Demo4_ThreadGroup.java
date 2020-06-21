package org.designpatterns.thread;

public class Demo4_ThreadGroup {
    public static void main(String[] args) {
        //demo1();
        ThreadGroup tg1 = new ThreadGroup("新线程组");

        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(tg1, mr, "张三");
        Thread t2 = new Thread(tg1, mr, "李四");

        System.out.println(t1.getThreadGroup().getName());
        System.out.println(t2.getThreadGroup().getName());

        tg1.setDaemon(true);
    }

    public static void demo1() {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr,"张三");
        Thread t2 = new Thread(mr,"李思");

        ThreadGroup tg1 = t1.getThreadGroup();
        ThreadGroup tg2 = t1.getThreadGroup();

        System.out.println(tg1.getName());
        System.out.println(tg2.getName());
    }
}


class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
      System.out.println(Thread.currentThread().getName() + "....." + i);
        }
    }
}