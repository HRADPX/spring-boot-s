package com.kuaishou.springboot.code.dp;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-05
 *
 * 2 1 3
 * 6 5 4
 * 7 8 9
 */
public class MinFallingPathSum_931 {

    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int rs = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (j == 0 && n > 1)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                else if (j == 0)
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                else if (j == n - 1)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i - 1][j + 1]) + matrix[i][j];
                if (i == m - 1) rs = Math.min(rs, dp[i][j]);
            }
        }
        return rs;
    }

    public static void main(String[] args) {

//        int[][] matrix = {{2,1,3}, {6,5,4}, {7,8,9}};
        int[][] matrix = {{2,1,3}, {6,5,4}};
//        int[][] matrix = {{-19,57},{-40,-5}};
//        int[][] matrix = {{2,1,3}};
//        int[][] matrix = {{2},{1},{3}};
        System.out.println(ReflectUtils.getInstance(MinFallingPathSum_931.class).minFallingPathSum(matrix));
    }
}
