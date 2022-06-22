package com.daryl.demo;

import java.util.*;

/**
 * @author wl
 * @create 2021-12-17
 */
public class Test01 {
    public static void main(String[] args) throws Exception{
        Student zhangsan = new Student();
        zhangsan.setAge("18");
        zhangsan.setName("lisi");
        System.out.println("---------------------------------------------------------------------");
        Object clone = zhangsan.clone();
        System.out.println(clone);
        //Student.class.newInstance();
        //objects.addFirst();
    }
}
