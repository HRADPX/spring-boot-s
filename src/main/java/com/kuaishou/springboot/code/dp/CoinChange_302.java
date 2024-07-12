package com.kuaishou.springboot.code.dp;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-04
 *
 * 每种硬币的数量是无限的
 */
public class CoinChange_302 {

    private int rs = Integer.MAX_VALUE;

    // 贪心，超时
    public int coinChangeV1(int[] coins, int amount) {

        if (coins == null || coins.length == 0 || amount <= 0) return 0;
        coinChange(coins, coins.length - 1, 0, amount);

        return rs == Integer.MAX_VALUE ? -1 : rs;
    }

    private void coinChange(int[] coins, int idx, int count, int amount) {

        if (idx < 0) return;

        int coin = coins[idx];
        for (int i = amount / coin; i >= 0; i--) {
            if (count + 1 >= rs) break;
            if (amount - i * coin == 0) {
                rs = Math.min(count, rs);
                return;
            }
            count += i;
            coinChange(coins, idx - 1, count, amount - i * coin);
            count -= i;
        }
    }

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0 || amount <= 0) return 0;
        Arrays.sort(coins);

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (coin <= j)
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }



    public static void main(String[] args) {

        int[] coins = {411,412,413,414,415,416,417,418,419,420,421,422};
        System.out.println(ReflectUtils.getInstance(CoinChange_302.class).coinChangeV1(coins, 9864));
    }

}
