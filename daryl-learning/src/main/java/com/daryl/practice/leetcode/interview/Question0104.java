package com.daryl.practice.leetcode.interview;

import java.util.Arrays;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * @author wl
 * @create 2022-03-29
 */
public class Question0104 {

    public static void main(String[] args) {
        String s = "tactcseooaiisaynobody";
       String[] arr = {"a","b","c"};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(arr));

        System.out.println(s);
/*        int t = s.indexOf("t", 3);
        System.out.println(t);*/
       // System.out.println(canPermutePalindrome(s));
    }

    public static boolean canPermutePalindrome(String s) {
        int length = s.length();
        if (length % 2 == 0) {
            for (int i = 0; i < length; i++) {
                String only = String.valueOf(s.charAt(i));
                int index = 1;
                int count = 0;
                int max = 0;
                if (only.equals(" ")){
                    continue;
                }
                while (index >= 1) {
                    index = s.indexOf(only, index);
                    count++;
                    if (index>max){
                        max = index;
                    }else{
                        break;
                    }
                }
                if (count % 2 != 0) {
                    return false;
                } else {
                    s = s.replace(only, " ");
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                String only = String.valueOf(s.charAt(i));
                int index = 1;
                int count = 0;
                int unique = 0;
                int max = 0;
                if (only.equals(" ")){
                    continue;
                }
                while (index >= 1) {
                    index = s.indexOf(only, index);
                    count++;
                    if (index>max){
                        max = index;
                    }else{
                        break;
                    }
                }
                if (count % 2 != 0) {
                    unique++;
                    if (unique>1){
                        return false;
                    }
                } else {
                    s = s.replace(only, " ");
                }
            }
        }
        return true;
    }
}
