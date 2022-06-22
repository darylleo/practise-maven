package com.daryl.leetcode;

/**
 * @author wl
 * @create 2022-01-13
 */
public class LeetCode067 {
    public static void main(String[] args) {
        System.out.println(addBinary("100", "110010"));
    }

    public static  String addBinary(String a, String b) {
        int count = 0;
        String part ;
        String add;
        StringBuilder sb = new StringBuilder();
        if (a.length()> b.length()){
             part = a.substring(0,a.length() - b.length());
             add = a.substring(a.length() - b.length());
            for (int i = b.length(); i>0; i--) {
                int value = Integer.parseInt(add.substring(i - 1, i))+Integer.parseInt(b.substring(i - 1, i));
                if (count == 1){
                    value+=1;
                    count = 0;
                }
                if (value == 2){
                    count +=1;
                    value = 0;
                }
                if (value == 3){
                    value = 1;
                    count = 1;
                }
                sb.append(value);
            }
            if (count == 0){
                return part + sb.reverse().toString();
            }else{
                for (int i = part.length(); i >0; i--) {
                    int value = Integer.parseInt(a.substring(i - 1, i));
                    if (count == 1){
                        value+=1;
                        count = 0;
                    }
                    if (value == 2){
                        count +=1;
                        value = 0;
                    }
                    if (value == 3){
                        value = 1;
                        count = 1;
                    }
                    sb.append(value);
                }
                if (count ==1){
                    sb.append("1");
                }
                return sb.reverse().toString();
            }


        }else if (a.length()<b.length()){
            part = b.substring(0,b.length() - a.length());
            add = b.substring(b.length() - a.length());
            for (int i = a.length(); i>0; i--) {
                int value = Integer.parseInt(a.substring(i - 1, i))+Integer.parseInt(add.substring(i - 1, i));
                if (count == 1){
                    value+=1;
                    count = 0;
                }
                if (value == 2){
                    count +=1;
                    value = 0;
                }
                if (value == 3){
                    value = 1;
                    count = 1;
                }
                sb.append(value);
            }
            if (count == 0){
                return part + sb.reverse().toString();
            }else {
                for (int i = part.length(); i >0; i--) {
                    int value = Integer.parseInt(b.substring(i - 1, i));
                    if (count == 1){
                        value+=1;
                        count = 0;
                    }
                    if (value == 2){
                        count +=1;
                        value = 0;
                    }
                    if (value == 3){
                        value = 1;
                        count = 1;
                    }
                    sb.append(value);
                }
                if (count ==1){
                    sb.append("1");
                }
                return sb.reverse().toString();
            }
        }else{
            //part = a.substring(0,a.length() - b.length());
            for (int i = b.length(); i>0; i--) {
                int value = Integer.parseInt(a.substring(i - 1, i))+Integer.parseInt(b.substring(i - 1, i));
                if (count == 1){
                    value+=1;
                    count = 0;
                }
                if (value == 2){
                    count +=1;
                    value = 0;
                }
                if (value == 3){
                    value = 1;
                    count = 1;
                }
                sb.append(value);
            }
            if (count == 0){
                return sb.reverse().toString();
            }else{
                sb.append("1");
                return sb.reverse().toString();
            }

        }

    }


}
