package org.reflection.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo2_Reflect {
  public static void main(String[] args) throws Exception {
    // 不使用反射，仅使用多态
    //      Juicer j = new Juicer();
    //      j.run(new Apple());
    //      j.run(new Orange());

    // 使用反射和配置
    BufferedReader br =
        new BufferedReader(new FileReader("src/main/java/org/reflection/config.properties"));
      Class clazz = Class.forName(br.readLine());

      Fruit f = (Fruit) clazz.newInstance();
      Juicer j = new Juicer();
      j.run(f);

  }
}

interface Fruit {
    public void squeeze();
}

class Apple implements Fruit {
    @Override
    public void squeeze() {
        System.out.println("苹果榨汁");
    }
}

class Orange implements Fruit {
    @Override
    public void squeeze() {
        System.out.println("桔子榨汁");
    }
}
class Juicer {
    /*public void run(Apple a) {
        a.squeeze();
    }

    public void run(Orange o) {
        o.squeeze();
    }*/

    public void run(Fruit f) {
        f.squeeze();
    }
}