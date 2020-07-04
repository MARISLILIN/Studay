package org.reflection.枚举.枚举类;

public class Demo2_Enum {
  public static void main(String[] args) {

      //demo1();
//通过字节码文件获取枚举项
      Week2 mon = Week2.valueOf(Week2.class, "MON");
      System.out.println(mon);
      Week2[] arr = Week2.values();
    for (Week2 week2 : arr) {
      System.out.println(week2);
    }
  }

    public static void demo1() {
        Week2 mon = Week2.MON;
        Week2 tue = Week2.TUE;
        Week2 wed = Week2.WED;
//枚举项的编号
        System.out.println(mon.ordinal());
        System.out.println(tue.ordinal());
        System.out.println(wed.ordinal());
//枚举的比较，比较的是编号
        System.out.println(mon.compareTo(tue));
        System.out.println(mon.compareTo(wed));
//获取实例的名称
        System.out.println(mon.name());
        //不重写tostring，使用默认的enum的tostring打印实例名称
        System.out.println(mon.toString());
    }

}
