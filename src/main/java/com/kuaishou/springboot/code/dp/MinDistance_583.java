package com.kuaishou.springboot.code.dp;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-19
 */
public class MinDistance_583 {

    public int minDistance(String word1, String word2) {

        if (word1.isEmpty() || word2.isEmpty())
            return word1.length() + word2.length();

        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();

        int[][] dp = new int[cs2.length + 1][cs1.length + 1];
        for (int i = 1; i <= cs2.length; i++)
            dp[i][0] = i;

        for (int i = 1; i <= cs1.length; i++)
            dp[0][i] = i;

        for (int i = 1; i <= cs2.length; i++) {
            for (int j = 1; j <= cs1.length; j++) {
                if (cs1[j - 1] == cs2[i - 1])
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
            }
        }
        return dp[cs2.length][cs1.length];
    }


    public static void main(String[] args) {
        System.out.println(ReflectUtils.getInstance(MinDistance_583.class).minDistance("intention", "execution"));
    }
}
