package com.daryl.practice.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author wl
 * @date 2022-06-30
 */
public class LeetCode200 {

    public static void main(String[] args) {
//        char[][] ints = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0','0', '0', '0'}
//        };

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int count = 0;
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            char[] anInt = grid[i];
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < anInt.length; j++) {
                char c = anInt[j];
                if ((int) c - 48 == 1) {
//                    if (j - 1 >= 0 && anInt[j - 1] - 48 == 0) {
//                        count++;
//                    }
                    count ++;
                    boolean left = true;
                    if (j - 1 >= 0) {
                        left = (int) anInt[j - 1] - 48 == 0;
                    }
                    if (j + 1 < anInt.length) {
                        left = (int) anInt[j + 1] - 48 == 0;
                    }
                    if (i - 1 >= 0) {
                        left = (int) grid[i - 1][j] - 48 == 0;
                    }
                    if (i + 1 < grid.length) {
                        left = (int) grid[i + 1][j] - 48 == 0;
                    }
                    if (left) {
                        count++;
                    }else {
                        count --;
                    }
                }
            }
        }

        System.out.println(count);
        //
        // System.out.println( 1==1 && 1!=1);
        //System.out.println((int)'2');
    }

    @Test
    public void test01(){
        Object[] ints = {1,2,3,4,5};
        String[] test = {"zhangSan","liSi","wangWu"};
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> strings = Arrays.asList(test);
        List<Object> objects = Arrays.asList(ints);
    }
}
