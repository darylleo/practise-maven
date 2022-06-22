package com.daryl.leetcode;

import com.daryl.util.NumUtils;
import org.junit.Test;

import java.util.ArrayList;

public class LeetCode202 {

    @Test
    public void test() {
        int n = 234;
        System.out.println(isHappy2(n));
    }

    public boolean isHappy(int n) {
        String strN = String.valueOf(n);
        int sum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (true) {
            for (int i = 0; i < strN.length(); i++) {
                sum += Math.pow(Integer.parseInt(strN.substring(i, i + 1)), 2);
            }
            if (result.contains(sum)) {
                return false;
            }
            if (sum == 1) {
                return true;
            }
            result.add(sum);
            sum = 0;
        }
    }

    public boolean isHappy2(int n) {

        ArrayList<Integer> sameResult = new ArrayList<>();
        while (true) {
            int sum = 0;
            for (Integer integer : new NumUtils().getEveryNum(n, new ArrayList<>())) {
                sum += Math.pow(integer, 2);
            }
            if (sum == 1) {
                return true;
            }
            if (sameResult.contains(sum)) {
                return false;
            }
            sameResult.add(sum);
            n = sum;
        }
    }
}
