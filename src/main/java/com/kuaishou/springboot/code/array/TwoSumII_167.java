package com.kuaishou.springboot.code.array;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-24
 */
public class TwoSumII_167 {

    public int[] twoSumII(int[] nums, int sum) {

        if (nums == null || nums.length < 2) {
            return new int[] {0, 0};
        }

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int curSum = nums[low] + nums[high];
            if (curSum > sum) {
                high--;
            } else if (curSum < sum) {
                low++;
            } else {
                return new int[] {low + 1, high + 1};
            }
        }
        return new int[] {0, 0};
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 6, 6, 7};
        System.out.println(Arrays.toString(ReflectUtils.getInstance(TwoSumII_167.class).twoSumII(nums, 9)));
    }
}
