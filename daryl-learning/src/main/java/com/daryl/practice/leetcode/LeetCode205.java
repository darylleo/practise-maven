package com.daryl.practice.leetcode;

import java.util.*;

/**
 * ClassDescription
 *
 * @author wl
 * @create 2022-03-31
 */
public class LeetCode205 {

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic2(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int count1 = 0;
        int count2 = 0;
        HashSet<Character> characterHashSet1 = new HashSet<>();
        HashSet<Character> characterHashSet2 = new HashSet<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c1 = t.charAt(i);
            if (characterHashSet1.add(c)) {
                count1 = 1;
            } else {
                count1++;
            }
            if (characterHashSet2.add(c1)) {
                count2 = 1;
            } else {
                count2++;
            }
            list1.add(count1);
            list2.add(count2);
        }

        return list1.toString().equals(list2.toString());
    }

    public static boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        Map<Character, Character> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c1 = t.charAt(i);
            if (characterIntegerMap.containsKey(c) && characterIntegerMap.get(c) - c1 != 0) {
                return false;
            }
            if (characterIntegerMap.containsValue(c1) && !characterIntegerMap.containsKey(c)) {
                return false;
            }
            characterIntegerMap.put(c, c1);
        }
        return true;
    }

    public static boolean isIsomorphic3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c1 = t.charAt(i);
            if (c-c1 !=0){

            }
        }

        return true;
    }
}
