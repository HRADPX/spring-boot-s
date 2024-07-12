package com.kuaishou.springboot.code.dp;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-19
 */
public class MinDistance_72 {

    // word1 = "horse", word2 = "ros"
    public int minDistance(String word1, String word2) {

        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();

        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();

        int[][] dp = new int[cs2.length + 1][cs1.length + 1];
        for (int i = 1; i <= cs1.length; i++)
            dp[0][i] = i;

        for (int i = 1; i <= cs2.length; i++)
            dp[i][0] = i;

        for (int i = 1; i <= cs2.length; i++) {
            for (int j = 1; j <= cs1.length; j++) {
                int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                if (cs1[j - 1] == cs2[i - 1])
                    dp[i][j] = min;
                else
                    dp[i][j] = min + 1;
            }
        }
        return dp[cs2.length][cs1.length];
    }

    public static void main(String[] args) {

        System.out.println(ReflectUtils.getInstance(MinDistance_72.class).minDistance("sea", "ate"));
    }
}
