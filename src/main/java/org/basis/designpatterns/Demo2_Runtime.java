package org.basis.designpatterns;

import java.io.IOException;

public class Demo2_Runtime {
  public static void main(String[] args) throws IOException {
    Runtime r = Runtime.getRuntime();
    //        r.exec("shutdown -s -t 300");
    r.exec("shutdown -a");
  }
}
