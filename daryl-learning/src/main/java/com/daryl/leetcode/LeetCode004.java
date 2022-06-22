package com.daryl.leetcode;


import java.util.Map;
import java.util.TreeMap;

/**
 * 寻找两个正序数组的中位数
 *
 * @author wl
 * @create 2021-12-28
 */
public class LeetCode004 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length == 0 && nums2.length == 1) || (nums1.length == 1 && nums2.length == 0)) {
            if (nums1.length == 1) {
                return nums1[0];
            } else {
                return nums2[0];
            }
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : nums1) {
           if (treeMap.get(i)==null){
               treeMap.put(i, 1);
           }else{
               treeMap.put(i, treeMap.get(i)+1);
           }
        }
        for (int i : nums2) {
            treeMap.merge(i, 1, Integer::sum);
        }
        int[] ints = new int[nums1.length + nums2.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            for (int i = index; i <index + entry.getValue(); i++) {
                ints[i] = entry.getKey();
            }
            index += entry.getValue();
        }
        if (ints.length%2==0){
            return (ints[ints.length/2]+ints[ints.length/2-1])/2.0;
        }
        return ints[ints.length/2];
    }
}
