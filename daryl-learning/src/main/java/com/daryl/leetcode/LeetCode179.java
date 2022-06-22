package com.daryl.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wl
 * @create 2022-02-17
 */
public class LeetCode179 {
    public static void main(String[] args) {
        // System.out.println(Integer.parseInt("999999991" + 9));
        //[3,30,34,5,9]
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num+"");
        }
        if (list.stream().allMatch("0"::equals)) {
            return list.get(0);
        }
        List<String> collect = list.stream().sorted((o1, o2) -> {
            if (Integer.parseInt(o2.substring(0, 1)) == Integer.parseInt(o1.substring(0, 1))) {
                if (o1.length() == o2.length()) {
                    return Integer.parseInt(o2) - Integer.parseInt(o1);
                } else {
                    return find(o1 + o2, o2 + o1);
                }
            }
            return Integer.parseInt(o2.substring(0, 1)) - Integer.parseInt(o1.substring(0, 1));
        }).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (String s : collect) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static Integer find(String first, String second) {
        if (Integer.parseInt(first.substring(0, 1)) > Integer.parseInt(second.substring(0, 1))) {
            return -1;
        } else if (Integer.parseInt(first.substring(0, 1)) < Integer.parseInt(second.substring(0, 1))) {
            return 1;
        }
        if (first.length() > 1 && second.length() > 1) {
            first = first.substring(1);
            second = second.substring(1);
        } else {
            return 1;
        }
        return find(first, second);
    }
}
