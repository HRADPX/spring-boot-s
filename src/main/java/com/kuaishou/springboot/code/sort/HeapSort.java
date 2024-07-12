package com.kuaishou.springboot.code.sort;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-29
 */
public class HeapSort {

    public void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapfiy(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapfiy(nums, 0, i + 1);
        }
        System.out.println(Arrays.toString(nums));
    }
//

//    [9, 6, 8, 5, 1, 7, 3, 2, 4]
//    private void heapfiy(int[] nums, int i, int n) {
//
//        int left = i * 2 + 1;
//        while (left < n) {
//
//            if (nums[i] < nums[left]) {
//                swap(nums, i, left);
//            }
//            if (nums[i] < nums[left + 1]) {
//                swap(nums, i, left + 1);
//            }
//            i = left;
//            left = i * 2 + 1;
//        }
//    }

    private void heapfiy(int[] nums, int i, int high) {

        int left = (i << 1) + 1;
        int right = (i << 1) + 2;
        int max = i;
        if(left < high && nums[left] > nums[max])
            max = left;
        if(right < high && nums[right] > nums[max])
            max = right;
        if(max != i){
            swap(nums,i,max);
            heapfiy(nums,max,high);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {4, 2, 7, 6, 1, 9, 3, 8, 5};
        ReflectUtils.getInstance(HeapSort.class).heapSort(nums);
    }
}
