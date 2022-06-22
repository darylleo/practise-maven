package com.daryl.mytest;

import com.daryl.mapper.UserMapper;

/**
 * ClassDescription
 *
 * @author wl
 * @create 2022-06-16
 */
public class Yuan {
    Person person = new Person("main");
    public static void main(String[] args) {
//        UserMapper.test();
//        System.out.println(UserMapper.s);

        new Test();
    }

    public static int getSum(int a, int b) {
        if (a == b) {
            return a;
        }
        int sum = 0;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int length = max - min;
        //小于改为 < = 然后 换一下顺序
        for (int i = 0; i <= length; i++) {
            sum += min;
            min += 1;
        }
        return sum;
    }

}
class Person{
    public Person(String s){
        System.out.println(s);
    }
}
class Test{
    Person person = new Person("test");
    static{
        System.out.println("test static ");
    }
    public Test(){
        System.out.println("test constructor");
    }
}

