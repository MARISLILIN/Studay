package org.basis.reflection.枚举.自己实现;

public class Demo1_Enum {
  public static void main(String[] args) {
      //demo1();
//      demo2();
      Week3 mon = Week3.MON;
      mon.show();


  }

    public static void demo2() {
        Week2 mon = Week2.MON;
        System.out.println(mon.getName());
    }

    public static void demo1() {
        Week mon = Week.MON;
        Week tue = Week.TUE;
        Week wed = Week.WED;
        System.out.println(mon);
        System.out.println(tue);
        System.out.println(wed);
    }
}
