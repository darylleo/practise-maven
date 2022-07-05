package com.daryl.practice.leetcode;

/**
 * 力扣第三题，返回最长字串
 *
 * @author wl
 * @create 2021-12-28
 */
public class LeetCode003 {
    public static void main(String[] args) {
        //abcabcbb  bbbbb   pwwkew "ababddccada" "pwwkew" dvdf "ckilbkd"
        String s = "ckilbkd";
        System.out.println(lengthOfLongestSubstring(s));
        String s2 = "ckilb";
        System.out.println("pw".substring("pw".length() - 1));

    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        String res = "";
        String blank = "";
        String maxStr = "";
        for (char aChar : chars) {
            if (res.contains(blank + aChar)) {
                if (res.equals(blank) || res.substring(res.length() - 1).equals(blank + aChar)) {
                    res = blank + aChar;
                } else {
                    res = res.substring(res.indexOf(blank + aChar) + 1) + aChar;
                }
            } else {
                res = res + blank + aChar;
                if (maxStr.length() < res.length())
                    maxStr = res;
            }
        }
        return maxStr.length();
    }
}
