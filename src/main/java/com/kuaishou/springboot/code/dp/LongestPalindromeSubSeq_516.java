package com.kuaishou.springboot.code.dp;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-25
 *
 * leetcode 516 删除最少的字符使之成为最长的回文串行
 * leetcode 1312 插入最少的字符使之成为最长的回文串行
 */
public class LongestPalindromeSubSeq_516 {

    public int longestPalindromeSubSeq(String s) {

        if (s.length() <= 1) return s.length();

        char[] cs = s.toCharArray();
        int[][] dp = new int[cs.length][cs.length];

        for (int i = 0; i < cs.length; i++) {
            for (int j = i; j >= 0; j--) {

                if (i == j)
                    dp[j][i] = 1;
                else if (cs[j] == cs[i]) {
                    // if (i - j == 1)
                    //     dp[j][i] = 2;
                    // else
                    //     dp[j][i] = Math.max(dp[j + 1][i - 1] + 2, Math.max(dp[j][i - 1], dp[j + 1][i]));
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                } else {
                    // if (i - j == 1)
                    //     dp[j][i] = 1;
                    // else
                    //     dp[j][i] = Math.max(dp[j + 1][i - 1], Math.max(dp[j][i - 1], dp[j + 1][i]));
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                }

            }
        }
        for (int[] ints : dp)System.out.println(Arrays.toString(ints));
        return dp[0][cs.length - 1];
    }

    public static void main(String[] args) {

        System.out.println(ReflectUtils.getInstance(LongestPalindromeSubSeq_516.class)
                .longestPalindromeSubSeq("acddcadaacc"));
    }
}
