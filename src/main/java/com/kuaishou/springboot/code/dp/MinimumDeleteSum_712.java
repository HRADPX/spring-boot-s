package com.kuaishou.springboot.code.dp;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-24
 */
public class MinimumDeleteSum_712 {

    //    s1 = "delete", s2 = "leet"
    public int minimumDeleteSum(String s1, String s2) {

        if (s1.length() == 0 || s2.length() == 0)
            return this.numOfString(s1) + this.numOfString(s2);

        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();


        int[][] dp = new int[cs2.length + 1][cs1.length + 1];

        for (int i = 1; i <= cs1.length; i++)
            dp[0][i] = dp[0][i - 1] + cs1[i - 1];

        for (int i = 1; i <= cs2.length; i++)
            dp[i][0] = dp[i - 1][0] + cs2[i - 1];

        for (int i = 1; i <= cs2.length; i++) {
            for (int j = 1; j <= cs1.length; j++) {

                if (cs2[i - 1] == cs1[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + cs2[i - 1] + cs1[j - 1], Math.min(dp[i - 1][j] + cs2[i - 1], dp[i][j - 1] + cs1[j - 1]));
            }
        }

        for (int[] ints : dp)
            System.out.println(Arrays.toString(ints));

        return dp[cs2.length][cs1.length];

    }

    private int numOfString(String s) {
        int ans = 0;
        for (char c : s.toCharArray())
            ans += c;
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(ReflectUtils.getInstance(MinimumDeleteSum_712.class).minimumDeleteSum("sea", "eat"));
    }
}
