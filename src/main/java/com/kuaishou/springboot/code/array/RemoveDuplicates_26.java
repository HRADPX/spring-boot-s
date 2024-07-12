package com.kuaishou.springboot.code.array;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-28
 */
public class RemoveDuplicates_26 {

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int idx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[idx]) continue;
            nums[++idx] = nums[i];
        }
        return idx + 1;
    }

    public static int removeDuplicatesV1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int slow = 0;
        int fast = 1;

        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                nums[++slow] = nums[fast++];
            }
        }
        return ++slow;
    }


    public static int removeDuplicatesV1(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        // 下一个可以写入的位置
        int idx = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[idx++] = nums[fast];
            }
            fast++;
        }
        return ++idx;
    }


    public static void main(String[] args) {

        int[] array = {1, 1, 2, 2, 0};
        System.out.println(removeDuplicatesV1(array, 1));
    }
}
