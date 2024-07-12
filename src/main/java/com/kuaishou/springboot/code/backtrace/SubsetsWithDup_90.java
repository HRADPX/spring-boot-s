package com.kuaishou.springboot.code.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-21
 */
public class SubsetsWithDup_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        backtrace(nums, 0, rs, list);
        return rs;
    }

    private void backtrace(int[] nums, int idx, List<List<Integer>> rs, List<Integer> list) {

        rs.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {

            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backtrace(nums, i + 1, rs, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(ReflectUtils.getInstance(SubsetsWithDup_90.class).subsetsWithDup(nums));
    }
}
