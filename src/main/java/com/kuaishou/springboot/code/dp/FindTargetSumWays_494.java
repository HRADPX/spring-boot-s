package com.kuaishou.springboot.code.dp;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-08
 */
public class FindTargetSumWays_494 {

    // 目标和
    // 标准 0-1背包
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) sum += num;

        if (sum + target < 0 || (sum + target) % 2 == 1) return 0;
        int[] dp = new int[(sum + target) / 2 + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,1,1};
        System.out.println(
                ReflectUtils.getInstance(FindTargetSumWays_494.class)
                .findTargetSumWays(array, 3)
        );
    }
}