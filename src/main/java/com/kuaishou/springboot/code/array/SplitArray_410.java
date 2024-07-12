package com.kuaishou.springboot.code.array;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-06
 *
 *
 * nums = [7,2,5,10,8], m = 2
 *
 * --> 18
 *
 * 将数组分成 K 份，使得每份和最小
 */
public class SplitArray_410 {

    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(num, low);
            high += num;
        }

        while (low < high) {
            int mid = (low + high) >>> 1;
            int cur = 0;
            int count = 1;

            for (int num : nums) {

                cur += num;
                if (cur > mid) {
                    count++;
                    cur = num;
                }
                if (count > k) {
                    break;
                }
            }
            if (count > k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {

        int[] array = {7,2,5,10,8};
        System.out.println(ReflectUtils.getInstance(SplitArray_410.class).splitArray(array, 2));
    }
}
