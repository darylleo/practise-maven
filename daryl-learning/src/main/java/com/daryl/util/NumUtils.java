package com.daryl.util;

import java.util.List;


public class NumUtils {

    /* ***                                                      Integer                                                           *** */

    /**
     * 获取一个整数的每一位数字
     *
     * @param num    整形数字
     * @param result 存放结果的集合（从左往右依次存放）
     * @return result
     */
    public List<Integer> getEveryNum(int num, List<Integer> result) {
        if (intNumLength(num) > 0) {
            Integer firstNum = intNumFirst(num);
            result.add(firstNum);
            return getEveryNum(intNumLeft(num), result);
        }
        result.add(num);
        return result;
    }

    /**
     * 获取整数第一个数字
     *
     * @param num 整数
     * @return 整数第一个数字
     */
    public Integer intNumFirst(int num) {
        return num / intNumDenominator(num);
    }

    /**
     * 获取整数第一个数字除外的剩余部分
     *
     * @param num 整数
     * @return 剩余部分
     */
    public Integer intNumLeft(int num) {
        return num == intNumFirst(num) * intNumDenominator(num) ? 0 : num - intNumFirst(num) * intNumDenominator(num);
    }

    /**
     * 获取除去首位数的剩余长度
     *
     * @param intNum 整数
     * @return length
     */
    public Integer intNumLength(int intNum) {
        int length = 0;
        while (intNum / 10 > 0) {
            length += 1;
            intNum = intNum / 10;
        }
        return length;
    }

    /**
     * 获得除数
     *
     * @param num 整数
     * @return 除数
     */
    private Integer intNumDenominator(int num) {
        Integer length = intNumLength(num);
        int denominator = 1;
        for (int i = 0; i < length; i++) {
            denominator *= 10;
        }
        return denominator;
    }
}
