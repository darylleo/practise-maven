package com.daryl.demo;



/**
 * @author wl
 * @create 2021-12-21
 */
public class Student implements Cloneable{
    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Student() {
        System.out.println("反射创建");
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student student;
        student = (Student) super.clone();
        return student;
    }

}
