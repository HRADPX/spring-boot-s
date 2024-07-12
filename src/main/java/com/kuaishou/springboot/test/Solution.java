package com.kuaishou.springboot.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-13
 */
public class Solution {

    // 给你一个整数数组nums，找出和为0的三个数，输出所有的组合
    public List<List<Integer>> findTargetSumList(int[] nums) {

        // -1, -1, 1, 2
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
                continue;
            }
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    // sum = 0
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j - 1] && nums[k] == nums[k + 1]) {
                        // 相同的组合
//                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        // -4 -1 -1 0 1 2
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumList(nums));
    }
}
