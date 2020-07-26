package org.basis.reflection.reflect;

import org.basis.reflection.bean.Person;

import java.lang.reflect.Constructor;

public class Demo3_Constructor {
  public static void main(String[] args) throws Exception {
      Class clazz = Class.forName("org.basis.reflection.bean.Person");
//      Person p = (Person) clazz.newInstance();
//    System.out.println(p);

      Constructor c = clazz.getConstructor(String.class, int.class);

      Person p = (Person) c.newInstance("张三", 23);
    System.out.println(p);
  }
}
