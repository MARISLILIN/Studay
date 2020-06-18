package org.recursion;

import java.io.File;

public class Demo4 {
  public static void main(String[] args) {
      File dir = Demo1.getDir();
      printLev(dir,0);
  }

    public static void printLev(File dir, int lev) {
        File[] subFiles = dir.listFiles();
        for (File subFile : subFiles) {
            for (int i = 0; i <= lev; i++) {
                System.out.print("\t");
            }
            System.out.println(subFile);
            if (subFile.isDirectory()) {
                printLev(subFile,lev + 1);
            }
        }
    }
}
