package com.kuaishou.springboot.code.dp;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-26
 */
public class ClimbStairs_70 {

    // 爬楼梯，这个和换硬币不同的是，第一次走两步第二次走一步 和 第一次走一步第二次走两步 是不同的解法，并没有重复。
    public int climbStairs(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;
        int result = 2;
        int diff = 1;
        int i = 3;

        while (i <= n) {
            result += diff;
            diff = result - diff;
            i++;
        }
        return result;
    }
}
