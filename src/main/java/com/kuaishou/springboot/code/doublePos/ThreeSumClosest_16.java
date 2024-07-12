package com.kuaishou.springboot.code.doublePos;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-21
 */
public class ThreeSumClosest_16 {

    public int threeSumClosest(int[] nums, int target) {
        // asset nums length at least 3
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1; int high = nums.length - 1;
            while (low < high) {
                int curSum = nums[i] + nums[low] + nums[high];
                if (curSum == target) return target;
                else if (Math.abs(sum - target) > Math.abs(curSum - target)) {
                    sum = curSum;
                    while (low < high && nums[low] == nums[low + 1]) ++low;
                    while (low < high && nums[high] == nums[high - 1]) --high;
                }
                ++low; --high;
            }
        }
        return sum;
    }
}
