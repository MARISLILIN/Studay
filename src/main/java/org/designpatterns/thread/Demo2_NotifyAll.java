package org.designpatterns.thread;

public class Demo2_NotifyAll {
    public static void main(String[] args) {
        final Printer2 p = new Printer2();
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

class Printer2 {
    private int flag = 1;
    public void print1() throws InterruptedException {
        synchronized (this) {
            while (flag != 1) {
                this.wait();
            }
            System.out.print("a");
            System.out.print("b");
            System.out.print("c");
            System.out.print("d");
            System.out.print("\r\n");
            flag = 2;
//            this.notify();
            this.notifyAll();
        }

    }
    public void print2() throws InterruptedException {
        synchronized (this) {
            while (flag != 2) {
                this.wait();
            }
            System.out.print("A");
            System.out.print("B");
            System.out.print("C");
            System.out.print("D");
            System.out.print("\r\n");
            flag = 3;
//            this.notify();
            this.notifyAll();
        }

    }
    public void print3() throws InterruptedException {
        synchronized (this) {
            while (flag != 3) {
                this.wait();
            }
            System.out.print("E");
            System.out.print("F");
            System.out.print("G");
            System.out.print("H");
            System.out.print("I");
            System.out.print("J");
            System.out.print("\r\n");
            flag = 1;
//            this.notify();
            this.notifyAll();
        }

    }
}