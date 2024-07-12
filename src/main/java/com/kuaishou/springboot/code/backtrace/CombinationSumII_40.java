package com.kuaishou.springboot.code.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.kuaishou.springboot.code.mark.Mark;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-11
 *  数组中有重复元素
 *  每个数字只能用一次
 *  不能有重复的集合
 */
public class CombinationSumII_40 implements Mark {

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
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (target < candidates[i]) break;
            list.add(candidates[i]);
            backtrace(candidates, ans, list, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,2,2,5};
        System.out.println(combinationSum(nums, 5));
    }
}
