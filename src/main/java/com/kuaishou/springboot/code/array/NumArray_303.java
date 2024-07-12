package com.kuaishou.springboot.code.array;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-24
 */
public class NumArray_303 {

    private final int[] sumArray;

    public NumArray_303(int[] nums) {
        this.sumArray = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sumArray[i + 1] = sumArray[i] + nums[i];
        }
    }

    /* 查询闭区间 [left, right] 的累加和 */
    public int sumRange(int left, int right) {
        return sumArray[right + 1] - sumArray[left];
    }

    public static void main(String[] args) {

        int[] array = {1, 3, -4, 9, 7};
        NumArray_303 instance = new NumArray_303(array);
        System.out.println(instance.sumRange(1, 3));
    }
}
