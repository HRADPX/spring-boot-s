package com.kuaishou.springboot.code.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-20
 */
public class PermuteUnique_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> rs = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);

        backtrace(nums,  flag, rs, list);
        return rs;
    }

    private void backtrace(int[] nums, boolean[] flag, List<List<Integer>> rs, List<Integer> list) {

        if (list.size() == nums.length) {
            rs.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (flag[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) continue;

            list.add(nums[i]);
            flag[i] = true;
            backtrace(nums, flag, rs, list);
            list.remove(list.size() - 1);
            flag[i] = false;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2};
        System.out.println(ReflectUtils.getInstance(PermuteUnique_47.class).permuteUnique(nums));
    }
}
