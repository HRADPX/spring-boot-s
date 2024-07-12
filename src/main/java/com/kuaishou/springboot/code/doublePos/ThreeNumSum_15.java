package com.kuaishou.springboot.code.doublePos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-21
 */
public class ThreeNumSum_15 {

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3)
            return Collections.emptyList();
        Arrays.sort(nums);

        List<List<Integer>> result = Lists.newArrayList();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] > 0) break;
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0)
                continue;
            int low = i + 1; int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum < 0) ++low;
                else if (sum > 0) --high;
                else {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) ++low;
                    while (low < high && nums[high] == nums[high - 1]) --high;
                    ++low; --high;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-4,-1,-1,0,1,2};
        Arrays.sort(nums);
        System.out.println(threeSum(nums));
    }
}
