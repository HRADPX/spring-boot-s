package com.kuaishou.springboot.code.array;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-29
 *
 *  5   1  9  11
 *  2   4  8  10
 *  13  3  6  7
 *  15 14 22  16
 *
 *  5  1  9
 *  2  4  8
 * 13  3  6
 */
public class Rotate_48 {

    public void rotate(int[][] matrix) {
        
        int n = matrix.length;

        for (int i = 0; i < (n >> 1); i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }


    public static void main(String[] args) {

        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,22,16}};
        System.out.println(Arrays.deepToString(matrix));
        ReflectUtils.getInstance(Rotate_48.class).rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

}
