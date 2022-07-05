package com.daryl.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangLi
 * @date 2022-06-2022/6/23
 */
public class LeetCode139 {

    public static void main(String[] args) {
        //"applepenapple"
        //["apple","pen"]
        //"catsandog"
        //["cats","dog","sand","and","cat"]
        //"bccdbacdbdacddabbaaaadababadad"
        //
        //["cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb"]
        String s = "catsandog";
        ArrayList<String> strings = new ArrayList<>();
        strings.add("cats");
        strings.add("dog");
        strings.add("sand");
        strings.add("and");
        strings.add("cat");
//        System.out.println("andog".indexOf("dog"));
//        System.out.println("andog".substring(0,2));
//        System.out.println("andog".substring(5));
//        System.out.println("----");
//        System.out.println("andog".substring("andog".indexOf("dog")+3));
        System.out.println(wordBreak(s, strings));
    }


    public static boolean wordBreak(String s, List<String> wordDict) {

        return false;
    }
    public static boolean findLast(String s, List<String> word){
        for (String s1 : word) {

        }
        return false;
    }
}
