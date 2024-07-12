package com.kuaishou.springboot.code.binarySearch;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-28
 */
public class MySqrt_69 {

    public int mySqrt(int x) {

        if (x <= 1) {
            return x;
        }
        int low = 1;
        int high = x;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            int div = x / mid;
            if (div == mid) {
                return mid;
            }
            if (div > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(ReflectUtils.getInstance(MySqrt_69.class).mySqrt(8));
    }
}
