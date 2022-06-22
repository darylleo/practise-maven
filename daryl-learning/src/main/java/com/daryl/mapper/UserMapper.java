package com.daryl.mapper;

import com.daryl.domain.Student;

/**
 * InterfaceDescription
 *
 * @author wl
 * @create 2022-06-16
 */
public interface UserMapper {

    int s = 1;

    public static void test() {
        System.out.println(666);
    }

    default String test2() {
        return "776";
    }
}
