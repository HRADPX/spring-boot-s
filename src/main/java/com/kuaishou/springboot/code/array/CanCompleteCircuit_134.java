package com.kuaishou.springboot.code.array;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-29
 *
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 */
public class CanCompleteCircuit_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        // 记录全程是否足够
        int sum = 0;
        int curSum = 0;
        int rs = 0;

        // 寻找最大子串问题
        for (int i = 0; i < gas.length; i++) {

            curSum += gas[i] - cost[i];
            if (curSum < 0) {
                curSum = 0;
                rs = i + 1;
            }
            sum += gas[i] - cost[i];
        }
        return sum >= 0 ? rs : -1;
    }


    public static void main(String[] args) {

        int[] gas = {3,1,1};
        int[] cost = {1,2,2};
        System.out.println(ReflectUtils.getInstance(CanCompleteCircuit_134.class).canCompleteCircuit(gas, cost));
    }
}
