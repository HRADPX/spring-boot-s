package com.kuaishou.springboot.code.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-20
 */
public class CombinationSum2_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(candidates);

        List<Integer> list = new ArrayList<>();
        backtrace(candidates, 0, 0, target, rs, list);
        return rs;
    }

    private void backtrace(int[] candidates, int idx, int curSum, int target, List<List<Integer>> rs, List<Integer> list) {

        if (curSum == target) {
            rs.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 去重
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            curSum += candidates[i];
            // 提前停止
            if (curSum > target) break;

            list.add(candidates[i]);
            this.backtrace(candidates, i + 1, curSum, target, rs, list);
            list.remove(list.size() - 1);
            curSum -= candidates[i];
        }
    }

    public static void main(String[] args) {

        int[] array = {10, 1, 2, 7, 6, 1, 5};

        System.out.println(ReflectUtils.getInstance(CombinationSum2_40.class).combinationSum2(array, 8));

    }
}
