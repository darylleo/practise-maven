package com.daryl.practice.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * @author wl
 * @create 2022-03-28
 */
public class Question0102 {

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "abb";
        System.out.println(CheckPermutation(s1, s2));
        System.out.println(CheckPermutation2(s1, s2));
    }

    // 错了  aab  abb
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() == s2.length()) {
            ArrayList<Character> list1 = new ArrayList<>();
            ArrayList<Character> list2 = new ArrayList<>();
            for (int i = 0; i < s1.length(); i++) {
                list1.add(s1.charAt(i));
                list2.add(s2.charAt(i));
            }
            return list1.containsAll(list2);
        }
        return false;
    }

    /*
    想着通过排序后再比较
    执行用时：3 ms, 在所有 Java 提交中击败了7.14%的用户
    内存消耗：39.1 MB,在所有 Java 提交中击败了40.47%的用户
 */
    public static boolean CheckPermutation2(String s1, String s2) {
        if (s1.length() == s2.length()) {
            ArrayList<Character> list1 = new ArrayList<>();
            ArrayList<Character> list2 = new ArrayList<>();
            for (int i = 0; i < s1.length(); i++) {
                list1.add(s1.charAt(i));
                list2.add(s2.charAt(i));
            }
            List<Character> collect = list1.stream().sorted(Character::compareTo).collect(Collectors.toList());
            List<Character> collect2 = list2.stream().sorted(Character::compareTo).collect(Collectors.toList());
            return collect.toString().equals(collect2.toString());
        }
        return false;
    }

    /*
    想着通过排序后再比较
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：39.4 MB,在所有 Java 提交中击败了5.68%的用户
    new String 39.1mb
*/
    public static boolean CheckPermutation3(String s1, String s2) {
        if (s1.length() == s2.length()) {
            char[] chars = s1.toCharArray();
            char[] chars1 = s2.toCharArray();
            Arrays.sort(chars);
            Arrays.sort(chars1);
            return new String(chars).equals(new String(chars1));
            //return Arrays.toString(chars).equals(Arrays.toString(chars1));
        }
        return false;
    }

    //桶计数
    public  boolean CheckPermutation4(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] c1 = count(s1);
        int[] c2 = count(s2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] count(String str) {
        int[] c = new int[26];
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            c[aChar - 'a']++;
        }
        return c;
    }
}







