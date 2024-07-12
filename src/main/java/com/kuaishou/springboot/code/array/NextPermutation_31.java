package com.kuaishou.springboot.code.array;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-30
 *  531 --> 135
 *  153 --> 315
 */
public class NextPermutation_31 {

    public static void nextPermutation(int[] nums) {

        if (nums == null || nums.length <= 1) return;
        int left = nums.length - 2;
        int right = nums.length - 1;
        while (left >= 0 && nums[left] >= nums[left + 1]) --left;
        if (left == -1) {
            Arrays.sort(nums);
            return;
        }
        while (right >= 0 && nums[right] <= nums[left]) --right;
        swap(nums, left, right);
        Arrays.sort(nums, left + 1, nums.length);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {6, 7, 6, 5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
