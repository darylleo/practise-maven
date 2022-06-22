package com.daryl.util;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 集合工具类
 *
 * @author wl
 * @create 2022-03-14
 */
public class ListUtils {

    /**
     * 有规律分隔的字符串转集合
     *
     * @param str   字符串
     * @param regex 分隔符
     * @return 集合
     */
    public static List<String> stringToList(String str, String regex) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        return Arrays.stream(str.split(regex)).collect(Collectors.toList());
    }

    /**
     * 确保mapper查询出的数据唯一
     *
     * @param list 非空集合
     * @param msg  不满足条件时的异常信息
     * @param <E>  集合中的元素
     * @return E
     */
    public static <E> E sizeCheck(List<E> list, String... msg) {
        if (list != null) {
            String emptyMessage = "数据不存在";
            String sizeOverMessage = "数据有误，存在多条";
            if (msg != null && msg.length > 0) {
                emptyMessage = msg[0];
                if (msg.length > 1) {
                    sizeOverMessage = msg[1];
                }
            }
            //抛出自定义异常
            if (list.isEmpty()) {
                throw new RuntimeException(emptyMessage);
            }
            if (list.size() > 1) {
                throw new RuntimeException(sizeOverMessage);
            }
            return list.get(0);
        }
        return null;
    }

    /**
     * 将Object转换成List
     *
     * @param obj   Object
     * @param clazz List中的数据类型
     * @return List
     */
    public static <T> List<T> castList(Object obj, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return result;
    }

    /**
     * 将Object转换成List
     *
     * @param obj   Object
     * @param clazz List中的数据类型
     * @return List
     */
    public static <T> List<List<T>> castTwoList(Object obj, Class<T> clazz) {
        List<List<T>> result = new ArrayList<>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                if (o instanceof List<?>) {
                    List<T> data = new ArrayList<>();
                    for (Object s : (List<?>) o) {
                        data.add(clazz.cast(s));
                    }
                    result.add(data);
                }
            }
        }
        return result;
    }
}
