package com.daryl.mytest.sorttest;

import org.junit.Test;

/**
 * 排序工具类
 */
public class SortUtils {

    @Test
    public void sortTest() {
        int[] ints = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("数组的长度为---------------------》》》》》" + ints.length);
        int[] empty = {};
        for (int result : bubbleSort(ints)) {
            System.out.print(result + "\t");
        }
    }

    /* ***                                        简单排序算法                                              *** */

    /**
     * 直接插入排序算法
     *
     * @param array 排序前
     * @return 排序后
     */
    public int[] directInsertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[0]) {
                int temp = array[i];
                array[i] = array[0];
                array[0] = temp;
                continue;
            }
            for (int j = i - 1; j > 0; j--) {
                if (array[i] < array[j] && array[i] >0)
                    if (array[i] >= array[j]) {

                    }
            }
        }
        return array;
    }

    /**
     * 冒泡排序算法（比较相邻两个元素，将大的放右边）-->每一次冒泡都会找出当前比较数里最大的
     *
     * @param array 排序前
     * @return 排序后
     */
    public int[] bubbleSort(int[] array) {
        //int count = 0;
        for (int i = array.length; i >= 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //count++;
                }
            }
        }
        //System.out.println(count);
        return array;
    }

    public int[] sort(int[] array) {
        //int count =  0 ;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    //count ++;
                }
            }
        }
        //System.out.println(count);
        return array;
    }

    private void swap(int a, int b) {
        //if (b>a)
    }
}
