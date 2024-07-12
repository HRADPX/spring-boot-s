package com.kuaishou.springboot.code.dp;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-08
 */
public class CombinationSum4_377 {

    // 完全背包，需要考虑顺序问题，先背包后物品，正序
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        System.out.println(
                ReflectUtils.getInstance(CombinationSum4_377.class).combinationSum4(nums, 4)
        );
    }
}
