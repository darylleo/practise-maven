package com.daryl.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wl
 * @create 2022-01-06
 */
public class LeetCode077 {
    public static void main(String[] args) {
        System.out.println(combine(9, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] ints = new int[n];
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ints[i] = i + 1;
            sb.append(i + 1).append(",");
        }
        //2
        int start = 0;
        int count = 0;
        int temp = k;
        while (count == k) {
            ArrayList<Integer> intList = new ArrayList<>();
            intList.add(Integer.parseInt(sb.substring(start, k)));
            intList.add(Integer.parseInt(sb.substring(k, k + 1)));
            k++;
            lists.add(intList);
            if (k == n) {
                count++;
            }
        }
        return null;
    }
}
