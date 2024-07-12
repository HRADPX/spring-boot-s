package com.kuaishou.springboot.code.collection;

import java.util.Arrays;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-16
 */
public class TwoSum_01 {

    public static int[] twoSum(int[] array, int sum) {

        if (array == null || array.length < 2) {
            return new int[] {};
        }
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) != null) {
                return new int[] {map.get(array[i]), i};
            }
            map.put(sum - array[i], i);
        }
        return new int[] {};
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,3,7};
        System.out.println(Arrays.toString(twoSum(array, 9)));

    }
}
