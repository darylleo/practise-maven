package com.daryl.practice.leetcode;

/**
 * 最长回文字串 （正反一样）
 *
 * @author wl
 * @create 2021-12-28
 */
public class LeetCode005 {

    public static void main(String[] args) {
        //"aacabdkacaa"
        String s = "mozblnzrszxtdjmwvgeovtxoftpcsbnjryogrnibiiqfexljlfikfcxvrzrpfvugtdjrlkgvkmrqgeltifdehsewpdhpjpnuobmuozopmglnocqcozvratjpzrklexqdeuvvzfjkuknkkoynxptrgtzadmpfdkphfjhdulhzncoofmmrwqjxeyhodfavcgpjmohohuztezdxegqzbaaobzrqptuqsvwnfdneyccbkgkjafztytwuppvleukdqqzyeiltsvoqbxupbasiityganofxijucwzqgtdyxljociwwjdrnfnfbwyymmvbuvbrdnvcubzkohknbsneutrcukfiqqhfviqdsbtrldipenqifdcrenpuyaqvkparycksurhbtjppwhezbcgocamurdawimkzzkmiwadrumacogcbzehwppjtbhruskcyrapkvqayupnercdfiqnepidlrtbsdqivfhqqifkucrtuensbnkhokzbucvndrbvubvmmyywbfnfnrdjwwicojlxydtgqzwcujixfonagytiisabpuxbqovstlieyzqqdkuelvppuwtytzfajkgkbccyendfnwvsqutpqrzboaabzqgexdzetzuhohomjpgcvafdohyexjqwrmmfoocnzhludhjfhpkdfpmdaztgrtpxnyokknkukjfzvvuedqxelkrzpjtarvzocqconlgmpozoumbounpjphdpweshedfitlegqrmkvgklrjdtguvfprzrvxcfkifljlxefqiibinrgoyrjnbscptfoxtvoegvwmjdtxzsrznlbzom";
        StringBuilder stringBuilder = new StringBuilder(s);
        System.out.println(s.equals(stringBuilder.reverse().toString()));
        System.out.println(test01(s));
    }

    public static String errorAnswer(String s) {
        String blank = "";
        String maxStr = blank;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!sb.toString().contains(blank + chars[i])) {
                sb.append(chars[i]);
                if (maxStr.equals(blank) && i == chars.length - 1) {
                    maxStr = chars[0] + blank;
                }
            } else {
                sb.append(chars[i]);
                if (sb.toString().substring(sb.indexOf(chars[i] + blank)).length() > maxStr.length()) {
                    maxStr = sb.toString().substring(sb.indexOf(chars[i] + blank));
                }
            }
        }
        return maxStr;
    }

    public static String longestPalindrome(String s) {
        String longest = s.substring(0, 1);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            String beginS = s.substring(j, j + 1);
            String leftS = s.substring(j + 1);
            if (leftS.contains(beginS)) {
                String temp = beginS + leftS.substring(0, leftS.lastIndexOf(beginS) + 1);
                sb.append(temp);
                while (temp.equals(sb.reverse().toString()) && temp.length() > longest.length()) {
                    longest = temp;
                    leftS = leftS.substring(leftS.indexOf(beginS) + 1);
                    if (!leftS.contains(beginS)) {
                        break;
                    }
                    temp += leftS.substring(0, leftS.indexOf(beginS) + 1);
                    sb.delete(0, sb.length()).append(temp);
                }
                sb.delete(0, sb.length());
            }
        }

        return longest;
    }

    /**
     * 超时了！！！！！！！！！！！！！！！！！！
     *
     * @param s
     * @return
     */
    public static String test01(String s) {
        if (s.length() == 1) {
            return s;
        }
        String empty = "";
        String longest = String.valueOf(s.charAt(0));
        while (s.length() > 1) {
            String first = s.charAt(0) + empty;
            if (s.lastIndexOf(first) != -1) {
                String tem = s;
                while (tem.lastIndexOf(first) != -1) {
                    int index = tem.lastIndexOf(first);
                    String sub = tem.substring(0, index + 1);
                    StringBuilder reverse = new StringBuilder(sub);
                    if (sub.equals(reverse.reverse().toString())) {
                        if (sub.length() > longest.length()) {
                            longest = sub;
                            break;
                        }
                    }
                    tem = tem.substring(0, index);
                }
            }
            //加了这个跳出条件后， 成功了。
            if (longest.equals(s)) {
                break;
            }
            s = s.substring(1);
        }
        return longest;
    }
}
