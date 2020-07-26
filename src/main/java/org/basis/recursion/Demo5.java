package org.basis.recursion;

import java.math.BigInteger;
import java.util.ArrayList;

public class Demo5 {
  public static void main(String[] args) {
    //     demo1();
    //      demo2();
    //      demo3();
    System.out.println(getLucklyNum(8));
  }
  public static int getLucklyNum(int num) {
      ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i <= num; i++) {
      list.add(i);
    }
    
    int count = 1;
    for (int i = 0; list.size() != 1; i++) {
        if (i == list.size()) {
            i = 0;
        }
        if (count % 3 == 0) {
            list.remove(i--);
        }
        count++;
    }
      return list.get(0);
  }

    public static void demo3() {
        BigInteger bi1 = new BigInteger("1");
        for (int i = 1; i <= 1000; i++) {
            BigInteger bi2 = new BigInteger(i + "");
            bi1 = bi1.multiply(bi2);
        }
        String str = bi1.toString();
        StringBuilder sb = new StringBuilder(str);
        str = sb.reverse().toString();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
          if ('0' != str.charAt(i)) {
              break;
          }else {
              count++;
          }
        }
        System.out.println(count);
    }

    public static void demo2() {
        BigInteger bi1 = new BigInteger("1");
        for (int i = 1; i <= 1000; i++) {
            BigInteger bi2 = new BigInteger(i + "");
            bi1 = bi1.multiply(bi2);
        }
        String str = bi1.toString();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ('0' == str.charAt(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static int fun(int num) {
      if (num == 1 || num == 2) {
          return 1;
      }else {
      return fun(num - 2) + fun(num - 1);
      }
  }
    private static void demo1() {
        int[] arr = new int[8];
        arr[0] = arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println(arr[arr.length - 1]);
    }
}
