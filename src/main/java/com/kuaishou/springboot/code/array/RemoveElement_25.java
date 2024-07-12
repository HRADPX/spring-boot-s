package com.kuaishou.springboot.code.array;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-29
 * uncheck
 */
public class RemoveElement_25 {

    public static int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) return 0;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            nums[idx++] = nums[i];
        }
        return idx;
    }

    public static void main(String[] args) {

        int[] array = {0,2,1,2};
        System.out.println(removeElement(array, 2));
    }
}
