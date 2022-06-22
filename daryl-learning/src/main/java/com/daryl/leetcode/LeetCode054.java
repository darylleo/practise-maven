package com.daryl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wl
 * @create 2021-12-30
 */
public class LeetCode054 {
    public static void main(String[] args) {
        // {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}} , {1, 2, 3,4}, { 5, 6,7,8}, {9, 10, 11,12} ,{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(spiralOrder(matrix));
        //[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
        //[1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 10, 11, 12, 16, 15]
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                res.add(matrix[0][i]);
            }
            return res;
        }
        int row = 0;
        int col = 0;
        int rowLength = matrix.length - 1;
        int colLength = matrix[0].length - 1;
        while (row < rowLength + 1) {
            res.add(matrix[row][col]);
            if (col != colLength && row != rowLength) {
                col++;
            } else {
                if (row != rowLength) {
                    row++;
                }
                if (row == rowLength && col == colLength) {
                    while (col >= 0 && row == rowLength) {
                        res.add(matrix[row][col]);
                        col--;
                        if (col == 0) {
                            res.add(matrix[row][col]);
                            row--;
                        }
                    }
                }
            }
            if (res.size() == matrix.length * matrix[0].length) {
                break;
            }
        }
        return res;
    }
}


