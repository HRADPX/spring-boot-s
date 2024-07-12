package com.kuaishou.springboot.code.dp;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-26
 */
public class CanPartition_416 {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;

        boolean[] dp = new boolean[sum / 2 + 1];
        // base case
        dp[0] = true;

        // 先物品后背包，物品不重复
        for (int num : nums) {
            for (int i = dp.length - 1; i > 0; i--) {
                if (i >= num)
                    dp[i] = dp[i] || dp[i - num];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[sum / 2];
    }

    public boolean canPartitionV1(int[] nums) {

        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum >>> 1) == 1) return false;

        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (j >= num)
                    dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum / 2];
    }

    public static void main(String[] args) {
        int[] arrays = {1, 5, 11, 5};
        System.out.println(ReflectUtils.getInstance(CanPartition_416.class).canPartitionV1(arrays));
    }
}
