package com.kuaishou.springboot.code.array;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-30
 */
public class GenerateMatrix_59 {

    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[0][];
        }
        int num = 1;
        int[][] rs = new int[n][n];

        for (int i = 0; i < n; i++) {

            // up
            for (int j = i; j < n - i; j++)
                rs[i][j] = num++;

            // right
            for (int j = i + 1; j < n - i; j++)
                rs[j][n - i - 1] = num++;

            // bottom
            for (int j = n - i - 2; j >= i && n - i - 1 > i; j--)
                rs[n - i - 1][j] = num++;

            // left
            for (int j = n - i - 2; j >= i + 1 && i < n - i - 1; j--)
                rs[j][i] = num++;
        }
        return rs;
    }

    public static void main(String[] args) {

        int[][] matrix = ReflectUtils.getInstance(GenerateMatrix_59.class).generateMatrix(0);
        System.out.println(Arrays.deepToString(matrix));
    }
}
