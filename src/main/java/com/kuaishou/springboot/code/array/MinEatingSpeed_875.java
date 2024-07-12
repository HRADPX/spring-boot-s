package com.kuaishou.springboot.code.array;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-06
 */
public class MinEatingSpeed_875 {


    public int minEatingSpeed(int[] piles, int h) {

        int low = 0;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {


            int mid = (low + high) >> 1;
            int hours = 0;

            for (int pile : piles) {
                hours += (pile % mid == 0) ? pile / mid : pile / mid + 1;
                if (hours > h) {
                    break;
                }
            }
            if (hours > h) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {

        int[] piles = {30,11,23,4,20};
        System.out.println(ReflectUtils.getInstance(MinEatingSpeed_875.class).minEatingSpeed(piles, 6));
    }
}
