package com.kuaishou.springboot.code.doublePos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-23
 */
public class FourSum_18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums == null || nums.length < 4)
            return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        // sort
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] > target) break;
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;
                int low = j + 1; int high = n - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum < target) ++low;
                    else if (sum > target) --high;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) ++low;
                        while (low < high && nums[high] == nums[high - 1]) --high;
                        ++low; --high;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[] {1,0,-1,0,-2,2};
        System.out.println(fourSum(nums, 0));
    }
}
