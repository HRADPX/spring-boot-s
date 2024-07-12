package com.kuaishou.springboot.code.doublePos;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-20
 */
public class MaxArea_11 {

    public static int maxArea(int[] array) {

        if (array == null || array.length <= 1)
            return 0;

        int ans = 0;
        int low = 0; int high = array.length - 1;
        while (low < high) {
            ans = Math.max((high - low) * Math.min(array[low], array[high]), ans);
            if (array[low] > array[high])
                --high;
            else
                ++low;
        }
        return ans;
    }
}
