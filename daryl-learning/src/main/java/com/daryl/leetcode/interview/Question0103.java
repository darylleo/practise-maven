package com.daryl.leetcode.interview;



import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.Arrays;

/**
 *URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * @author wl
 * @create 2022-03-28
 */
public class Question0103 {

    public static void main(String[] args) {
        String str= "Mr John Smith    ";
        System.out.println(replaceSpaces3(str, 13));
    }
    /*
    执行用时：100 ms, 在所有 Java 提交中击败了5.27%的用户
    内存消耗：49.3 MB,在所有 Java 提交中击败了8.05%的用户
*/
    public static String replaceSpaces(String S, int length) {
        String empty = "";
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            String res = S.charAt(i) + empty;
            if (res.equals(" ")){
                res = "%20";
            }
            stringBuilder.append(res) ;
        }
        return stringBuilder.toString();
    }

    // 9ms 83.64%  49.3mb  8.05
    public static String replaceSpaces2(String S, int length) {
        if (S == null || "".equals(S) || S.length() ==0 || length == 0){
            return null;
        }
        if(S.length() == length){
            return S.replace(" ","%20");
        }else{
            return S.substring(0,length).replace(" ","%20");
        }
    }

    //18ms  27.55%  49.1mb  21.49%
    public static String replaceSpaces3(String S, int length) {
        if (S == null || "".equals(S) || S.length() ==0 || length == 0){
            return null;
        }
        length = Math.min(S.length(), length);
        char[] chars = S.toCharArray();
        char[] res = new char[length];
        for (int i = 0; i < length; i++) {
            if (chars[i] - ' ' == 0) {
                res[i] = '→';
            }else{
                res[i] = chars[i];
            }
        }
        return new String(res).replace("→","%20");
    }

}
