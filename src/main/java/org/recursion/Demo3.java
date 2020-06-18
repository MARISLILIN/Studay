package org.recursion;

import java.io.*;

public class Demo3 {
  public static void main(String[] args) throws IOException {
      File src = Demo1.getDir();
      File dest = Demo1.getDir();
      if (src.equals(dest)) {
          System.out.println("目标文件夹是源文件夹的子文件夹");
          copy(src,dest);
      }
  }

    private static void copy(File src, File dest) throws IOException {
        File newDir = new File(dest, src.getName());
        newDir.mkdir();
        File[] subFiles = src.listFiles();
    for (File subFile : subFiles) {
        if (subFile.isFile()) {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(subFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(newDir, subFile.getName())));
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }

            bis.close();
            bos.close();
        }else {
            copy(subFile,newDir);
        }
    }
  }
}
