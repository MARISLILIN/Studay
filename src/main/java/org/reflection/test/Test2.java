package org.reflection.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test2 {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new FileReader("src\\main\\java\\org\\reflection\\xxx.properties"));
      Class clazz = Class.forName(br.readLine());

      DemoClass dc = (DemoClass)clazz.newInstance();
      dc.run();

  }
}
