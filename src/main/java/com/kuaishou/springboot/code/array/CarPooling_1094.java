package com.kuaishou.springboot.code.array;

import java.util.Arrays;
import java.util.Comparator;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-25
 *
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 *
 */
public class CarPooling_1094 {

    public boolean carPooling(int[][] trips, int capacity) {

        // 还在车上的人
        int[] on = new int[trips.length];
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));

        for (int j = 0; j < trips.length; j++) {
            // 当前的里程
            int currentStart = trips[j][1];
            // 到达当前里程下车的乘客 这里可以用小顶堆
            int a = j - 1;
            while (a >= 0) {
                if (on[a] >= 0 && currentStart >= trips[on[a]][2]) {
                    capacity += trips[on[a]][0];
                    on[a] = -1;
                }
                a--;
            }
            capacity -= trips[j][0];
            if (capacity < 0) {
                return false;
            }
            on[j] = j;
        }

        return true;
    }

    /**
     * 1: 开始
     * 2: 结束
     */
    public boolean carPoolingV1(int[][] trips, int capacity) {
        int[] sites = new int[1001];     //所有sites 等同一条路完整的路
        for(int[] trip : trips){       //添加每个站点上下人情况
            sites[trip[1]] += trip[0];   //起始站 上车 +人
            sites[trip[2]] -= trip[0];   //终点站 下车 -人
        }

        int car = 0;     //用一辆车 (car 存车上人数) 从头开始开过sites
        for(int site : sites){
            car += site;     //每到一站 从sites收集信息(上车 或 下车 或 不变)
            if(car > capacity){  //超载啦
                return false;
            }
        }
        return true;  //一直装得下
    }


    public static void main(String[] args) {

        int[][] trips = {{2,1,5},{3,5,7}};
        System.out.println(ReflectUtils.getInstance(CarPooling_1094.class).carPooling(trips, 3));
    }
}
