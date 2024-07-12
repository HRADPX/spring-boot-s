package com.kuaishou.springboot.code.dp;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-30
 *
 * 最长子序列
 * nums = [10,9,2,5,3,7,101,18]  ==> 4
 */
public class LengthOfLIS_300 {

    public int lengthOfLIS(int[] nums) {

        if (nums.length <= 1) return 1;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return max;
    }

    // 这种方法可以找出其中一个最长子串
    public int lengthOfLISV1(int[] nums) {

        if (nums.length <= 1) return 1;
        int index = 0;
        int[] ans = new int[nums.length];
        ans[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int idx = binarySearch(ans, index, nums[i]);
            if (idx <= index)
                ans[idx] = nums[i];
            else {
                ans[++index] = nums[i];
            }
        }
        System.out.println(Arrays.toString(ans));
        return ++index;
    }

    private int binarySearch(int[] ans, int high, int key) {
        int low = 0;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (ans[mid] == key)
                return mid;
            else if (ans[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {

//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {4,10,4,3,8,9};
        System.out.println(ReflectUtils.getInstance(LengthOfLIS_300.class).lengthOfLIS(nums));
        System.out.println(ReflectUtils.getInstance(LengthOfLIS_300.class).lengthOfLISV1(nums));
    }
}
