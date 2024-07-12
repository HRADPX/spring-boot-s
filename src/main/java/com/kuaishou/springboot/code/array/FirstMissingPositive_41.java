package com.kuaishou.springboot.code.array;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-11
 *     [1,2,0] --> 3
 *     [3,4,-1,1] --> 2
 *     [7,8,9,11,12] --> 1
 * O(N)
 */
public class FirstMissingPositive_41 {

    public static int firstMissingPositive(int[] nums) {

        boolean[] res = new boolean[nums.length + 1];
        int num = 0;
        for (int value : nums) {
            if (value <= 0) continue;
            if (value > nums.length) ++num;
            else res[value] = true;
        }
        if (num == nums.length) return 1;
        for (int i = 1; i < res.length; i++) {
            if (!res[i]) return i;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        System.out.println(firstMissingPositive(nums));
    }
}
