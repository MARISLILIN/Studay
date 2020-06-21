package org.designpatterns.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
//定时器
public class Demo3_Timer {
    public static void main(String[] args) throws InterruptedException {
        Timer t = new Timer();
        t.schedule(new MyTimerTask(), new Date(120, 5, 21, 0, 44,50),3000);

        while (true) {
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }
}

class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("啊实打实大苏打");
    }
}