package com.kuaishou.springboot.code.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.kuaishou.springboot.code.mark.Mark;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-11
 * 组合求和
 *   元素各不相同
 *   元素选取次数不作限制
 *   顺序不限制
 *  nums: {2, 3, 7} target: 7
 *  {2, 2, 3}, {7}
 */
public class CombinationSum_39 implements Mark {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length < 1) return Collections.emptyList();
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrace(candidates, ans, new ArrayList<>(), target, 0);
        return ans;
    }

    private static void backtrace(int[] candidates, List<List<Integer>> ans, List<Integer> list, int target, int index) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            list.add(candidates[i]);
            backtrace(candidates, ans, list, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 7};
        System.out.println(combinationSum(nums, 7));
    }
}
