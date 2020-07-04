package org.reflection.reflect;

import org.reflection.bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Demo4_Field {
  public static void main(String[] args) throws Exception {
      Class clazz = Class.forName("org.reflection.bean.Person");
      Constructor c = clazz.getConstructor(String.class, int.class);
      Person p = (Person) c.newInstance("张三", 23);
    System.out.println(p.toString());
    //报错: NoSuchFieldException 因为name私有
//    Field f = clazz.getField("name");
//      f.set(p,"李四");
      //报错:
      // IllegalAccessException:
      // Class org.reflection.reflect.Demo4_Field can not access a member of class org.reflection.bean.Person with modifiers "private"
      Field f = clazz.getDeclaredField("name");
      //去除私有的权限
      f.setAccessible(true);
      f.set(p,"李四");


      System.out.println(p.toString());
  }
}
