package org.basis.reflection.test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test1 {
    /**
     * @param args
     * ArraryList<Integer>的对象，增加一个字符串数据
     * 泛型只在编译期有效，在运行期会被擦除掉
     */
  public static void main(String[] args) throws Exception {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(111);
      list.add(222);


      Class clazz = Class.forName("java.util.ArrayList");
      Method m = clazz.getMethod("add", Object.class);
      m.invoke(list,"abc");

    System.out.println(list);
  }
}
