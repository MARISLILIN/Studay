package org.basis.designpatterns.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo5_Executors {
  public static void main(String[] args) {
      ExecutorService pool = Executors.newFixedThreadPool(2);
      pool.submit(new MyRunnable());
      pool.submit(new MyRunnable());

      pool.shutdown();
  }
}
