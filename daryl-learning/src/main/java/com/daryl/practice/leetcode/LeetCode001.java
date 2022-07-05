package com.daryl.practice.leetcode;

import java.util.HashMap;

/**
 * 力扣第一题-两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * nums : [1,2,3]   target : 3   result : [1,2]
 *
 * @author wl
 * @create 2021-12-06
 */
public class LeetCode001 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] ints = twoSum2(nums, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    //双重for循环---> 从第一个值开始，和后面每一个值相加看能否的到target
    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ints[0] = i;
                    ints[1] = j;
                }
            }
        }
        return ints;
    }

    //使用hash表   只有在提供的数组的值都不重复的前提下
    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] ints = new int[2];
        for (int num : nums) {
            if (map.containsKey(target - num)) {
                ints[0] = map.get(num);
                ints[1] = map.get(target - num);
                break;
            }
        }
        return ints;
    }
}
