package com.kuaishou.springboot.code.array;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-11
 */
public class Jump_45 {


    public static int jump0(int[] nums) {

        if (nums.length == 1) return 0;
        int mostRight = 0;
        int right = 0;
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {

        }
        return ans;
    }

    public static int jumpUgly(int[] nums) {

        if (nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        // init
        for (int i = 1; i < dp.length; i++)
            dp[i] = dp.length;

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] + j >= i)
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {

        int[] nums = {1,2,0,1,2};
        System.out.println(jumpUgly(nums));
    }
}
