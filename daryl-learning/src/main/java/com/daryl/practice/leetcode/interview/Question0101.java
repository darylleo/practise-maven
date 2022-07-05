package com.daryl.practice.leetcode.interview;

import java.util.HashSet;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * @author wl
 * @create 2022-03-28
 */
public class Question0101 {

    public static void main(String[] args) {
        String str = "leet";
        System.out.println(isUnique4(str));
    }

    /*
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：39.2 MB,在所有 Java 提交中击败了28.53%的用户
     */
    public static boolean isUnique(String astr) {
        HashSet<Character> charSet = new HashSet<>();
        char[] chars = astr.toCharArray();
        for (char aChar : chars) {
            if (!charSet.add(aChar)) {
                return false;
            }
        }
        return true;
    }

    /*
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：39.3 MB, 在所有 Java 提交中击败了11.05%的用户
     */
    public static boolean isUnique2(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            String res =  String.valueOf(astr.charAt(i));
            if (astr.indexOf(res) == astr.lastIndexOf(res)){
                continue;
            }
            return false;
        }
        return true;
    }

    /*
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：38.9 MB, 在所有 Java 提交中击败了49.03%的用户
    */
    public static boolean isUnique3(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            String res =  String.valueOf(astr.charAt(i));
            if (i == astr.lastIndexOf(res)){
                continue;
            }
            return false;
        }
        return true;
    }

    //评论看的 效率不高
    public static boolean isUnique4(String astr) {
        return astr.chars().distinct().count() == astr.length();
    }
}
