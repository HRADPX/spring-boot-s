package com.kuaishou.springboot.code.dp;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-25
 *
 * 1）0-1 背包：每个物品最多只能选一次，物品外层，背包内层，内层逆序。
 * 2）完全背包：物品无限，物品外层，背包内层，内层正序。
 * 3）如果是组合问题要考虑元素的之间的顺序，背包外层，物品内层。
 *
 * There is something inside that they can't get to that they can't touch.They are yours.
 */
public class ChangeII_518 {

    // 零钱兑换 -> 完全背包问题 -> 物品无限问题 -> 外层物品，内层背包正序
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            // 这里不能从 0 开始，不然会重复
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    // dp[i][j] = dp[i - 1][j] + dp[i][j - v])
    public int changeV1(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;  // 使用0种货币，凑0元钱,也是一种方案

        for (int i = 1; i <= n; i++) {
            int v = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                for (int k = 0; k * v <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * v];    //状态计算方程
                }
            }
        }
        return dp[n][amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        System.out.println(ReflectUtils.getInstance(ChangeII_518.class).change(5, coins));
    }
}
