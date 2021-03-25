package org.JDBC.util.bean;

public class PersonInfo {
    private int id;
    private String xm;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "id=" + id +
                ", name='" + xm + '\'' +
                ", age=" + age +
                '}';
    }
}
