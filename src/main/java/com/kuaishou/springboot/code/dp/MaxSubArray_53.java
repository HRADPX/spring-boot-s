package com.kuaishou.springboot.code.dp;

import java.util.ArrayList;
import java.util.List;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-19
 */
public class MaxSubArray_53 {

    // 只求结果
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {

            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    // 求最大子数组
    public int maxSubArrayV1(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int low = 0;
        int high = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            if (sum > max) {
                high = i;
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
                low = i + 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        // 如果全是负数，那么最大值就是最大子数组
        for (int i = Math.min(low, high); i <= high; i++) {
            ans.add(nums[i]);
        }
        System.out.println(ans);
        return max;
    }

    public static void main(String[] args) {

//        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        int[] array = {-2,-1,-3,-4,-1,-2,-1,-5};
        System.out.println(ReflectUtils.getInstance(MaxSubArray_53.class).maxSubArrayV1(array));
    }
}
