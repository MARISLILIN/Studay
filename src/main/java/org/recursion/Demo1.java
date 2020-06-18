package org.recursion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

public class Demo1 {
  public static void main(String[] args) throws IOException {
    //demo1();
    File dir = getDir();
    System.out.println(getFileLength(dir));
  }

  public static File getDir() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入一个文件夹路径");
    while (true) {
      String line = scanner.nextLine();
      File dir = new File(line);
      if (!dir.exists()) {
        System.out.println("您录入的文件夹路径不存在，请输入一个文件夹路径：");
      }else if (dir.isFile()) {
        System.out.println("您输入的是文件路径，请输入一个文件夹路径：");
      }else {
        return dir;
      }
    }
  }


  public static long getFileLength(File dir) {
    long len = 0;
    File[] subFiles = dir.listFiles();
    for (File subFile : subFiles) {
        if (subFile.isFile()) {
          len += subFile.length();
        }else {
          len += getFileLength(subFile);
        }
    }
    return len;
  }



  private static void demo1() throws IOException {
    Properties properties = new Properties();
    properties.load(new FileInputStream("config.properties"));
    Enumeration<String> enumeration = (Enumeration<String>) properties.propertyNames();
    System.out.println(enumeration.toString());

    System.out.println(properties.getProperty("url"));
  }

}
