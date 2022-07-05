package com.daryl.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wl
 * @create 2021-12-28
 */
public class LeetCode472 {
    public static void main(String[] args) {
        // ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(words));

        String test = "212345";
        String s = "123";
        System.out.println(test.substring(test.indexOf(s) + s.length(), test.indexOf(s) + s.length() + 1));
        System.out.println(test.indexOf(s));
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        List<String> strings = Arrays.asList(words);
        String blank = "";
        String temp = "test";
        for (int i = 0; i < words.length; i++) {
            temp = words[i];
            for (int j = 0; j < words.length; j++) {
                if (temp.length() < words[j].length()) {
                    continue;
                }
                while (temp.contains(words[j])) {
                    String anotherTemp = words[j];
                    while (temp.contains(anotherTemp) && strings.contains(anotherTemp)) {
                        //字串的最后一个字母 anotherTemp.substring(anotherTemp.length()-1) temp.indexOf(anotherTemp);

                        if (temp.indexOf(anotherTemp) + anotherTemp.length() < temp.length()) {
                            if (!(strings.contains(anotherTemp + temp.substring(temp.indexOf(anotherTemp) + anotherTemp.length(), temp.indexOf(anotherTemp) + anotherTemp.length() + 1)))) {
                                break;
                            }
                            anotherTemp = anotherTemp + temp.substring(temp.indexOf(anotherTemp) + anotherTemp.length(), temp.indexOf(anotherTemp) + anotherTemp.length() + 1);
                        }
                    }
                    temp = words[i].replace(anotherTemp, blank);
                }
                if (temp.length() == 0) {
                    res.add(words[i]);
                }
            }
        }
        return res;
    }
}
