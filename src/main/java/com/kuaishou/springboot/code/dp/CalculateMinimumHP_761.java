package com.kuaishou.springboot.code.dp;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-08
 */
@Deprecated
public class CalculateMinimumHP_761 {

    int res = Integer.MIN_VALUE;
    public int calculateMinimumHP(int[][] dungeon) {
//        calculateMinimumHP(dungeon, 0, 0, 0);

        return res;
    }

    public static void main(String[] args) {

        int[][] nums = {{-2,-3,3}, {-5,-10,1}, {10,30,-5}};
        System.out.println(ReflectUtils.getInstance(CalculateMinimumHP_761.class).calculateMinimumHP(nums));
    }
}
