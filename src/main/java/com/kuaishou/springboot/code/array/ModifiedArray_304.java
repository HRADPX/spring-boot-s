package com.kuaishou.springboot.code.array;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-26
 *
 * 差分
 */
public class ModifiedArray_304 {

    public int[] getModifiedArray(int length, int[][] updates) {

        int[] nums = new int[length];

        for (int[] update : updates) {

            int low = update[0];
            int high = update[1];

            nums[low] += update[2];
            if (high != nums.length - 1) {
                nums[high] -= update[2];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {

        int[][] update = {{1,3,2}, {2,4,3}, {0,2,-2}};
        System.out.println(Arrays.toString(ReflectUtils.getInstance(ModifiedArray_304.class)
                .getModifiedArray(5, update)));

    }
}
