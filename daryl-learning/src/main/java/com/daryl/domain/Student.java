package com.daryl.domain;

/**
 * @author wl
 * @create 2022-02-07
 */
public class Student {

    private Integer age;

    private String name;

    private String address;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Student yuan(){
        Student yuan = new Student();
        yuan.setAddress("zjslxsdyzx");
        yuan.setAge(24);
        yuan.setName("yuan");
        return yuan;
    }

    public static Student heHuoHuo(){
        Student heHuoHuo = new Student();
        heHuoHuo.setAddress("zjslxsdyzx");
        heHuoHuo.setAge(23);
        heHuoHuo.setName("heHuoHuo");
        return heHuoHuo;
    }

    public Student() {
        System.out.println("无参构造调用");
    }

    public Student(String s) {
        System.out.println("有参构造调用666");
    }
}
