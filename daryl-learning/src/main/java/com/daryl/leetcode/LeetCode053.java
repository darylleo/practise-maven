package com.daryl.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author wl
 * @create 2022-02-24
 */
public class LeetCode053 {
    @Test
    public void test01() {
        //-2,1,-3,4,-1,2,1,-5,4
        //5,4,-1,7,8
        //-2, -3, -1
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //System.out.println(maxSubArray(nums));;
        System.out.println(test(nums));
    }

    //超时
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] < 0) {
                if (nums[i] < nums[i + 1]) {
                    continue;
                }
            }
            sum = nums[i];
            if (sum > max) {
                max = sum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    //超时
    public int test(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxValue = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum > maxValue) {
                    maxValue = sum;
                }
            }
        }
        return maxValue;
    }
}
