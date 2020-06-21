package org.designpatterns.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo3_ReentrantLock {
    public static void main(String[] args) {
        final Printer3 p = new Printer3();

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
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        p.print3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}


class Printer3 {
    private ReentrantLock r = new ReentrantLock();
    private Condition c1 = r.newCondition();
    private Condition c2 = r.newCondition();
    private Condition c3 = r.newCondition();

    private int flag = 1;
    public void print1() throws InterruptedException {
        r.lock();
        if (flag != 1) {
            c1.await();
        }
        System.out.print("a");
        System.out.print("b");
        System.out.print("c");
        System.out.print("d");
        System.out.print("\r\n");
        flag = 2;
        c2.signal();
        r.unlock();

    }
    public void print2() throws InterruptedException {
        r.lock();
        if (flag != 2) {
            c2.await();
        }
        System.out.print("A");
        System.out.print("B");
        System.out.print("C");
        System.out.print("D");
        System.out.print("\r\n");
        flag = 3;
        c3.signal();
        r.unlock();

    }
    public void print3() throws InterruptedException {
        r.lock();
        if (flag != 3) {
           c3.await();
        }
        System.out.print("E");
        System.out.print("F");
        System.out.print("G");
        System.out.print("H");
        System.out.print("I");
        System.out.print("J");
        System.out.print("\r\n");
        flag = 1;
        c1.signal();
        r.unlock();

    }
}