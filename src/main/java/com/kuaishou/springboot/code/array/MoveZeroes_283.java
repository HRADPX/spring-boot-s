package com.kuaishou.springboot.code.array;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-24
 */
public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length <= 1)
            return;

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 0, 0, 3, 4};
        ReflectUtils.getInstance(MoveZeroes_283.class).moveZeroes(array);
    }

}
