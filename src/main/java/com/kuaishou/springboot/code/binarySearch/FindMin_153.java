package com.kuaishou.springboot.code.binarySearch;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-28
 */
public class FindMin_153 {

    public int findMin(int[] nums) {
        // [5,0,1,2,3,4]

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {

        int[] nums = {0,1,2,3,4,5,6};
        System.out.println(ReflectUtils.getInstance(FindMin_153.class).findMin(nums));
    }
}
