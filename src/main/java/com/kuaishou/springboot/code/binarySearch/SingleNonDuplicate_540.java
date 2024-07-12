package com.kuaishou.springboot.code.binarySearch;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-28
 */
public class SingleNonDuplicate_540 {


    public int singleNonDuplicateV1(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = (low + high) >>> 1;
            if ((mid & 1) == 1) {
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 2;
                } else {
                    high = mid;
                }
            }
        }
        return nums[low];
    }

    public int singleNonDuplicateV2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high + low) >>> 1;
            if (mid % 2 == 1) {
                mid--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public int singleNonDuplicate(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(ReflectUtils.getInstance(SingleNonDuplicate_540.class).singleNonDuplicateV1(nums));
    }
}
