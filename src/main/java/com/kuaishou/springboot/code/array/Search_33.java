package com.kuaishou.springboot.code.array;

import com.kuaishou.springboot.code.mark.Mark;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-10
 * 搜索旋转数组，数组中的值互不相同
 */
public class Search_33 implements Mark {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[high]) {
                if (target >= nums[low] && nums[mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (nums[mid] < target && nums[high] >= target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,1,2,3};
        System.out.println(search(nums, 8));
    }
}
