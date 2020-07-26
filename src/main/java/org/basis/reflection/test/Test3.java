package org.basis.reflection.test;

public class Test3 {
  public static void main(String[] args) throws Exception {
      Student s = new Student("张三", 23);
    System.out.println(s);

      Tool t = new Tool();
      t.setProperty(s, "name", "李四");
    System.out.println(s);
  }
}

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
