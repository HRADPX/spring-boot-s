package com.kuaishou.springboot.code.backtrace;

import java.util.ArrayList;
import java.util.List;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-21
 */
public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtrace(nums, 0, rs, list);
        return rs;
    }

    private void backtrace(int[] nums, int idx, List<List<Integer>> rs, List<Integer> list) {

        rs.add(new ArrayList<>(list));

        for (int j = idx; j < nums.length; j++) {

            list.add(nums[j]);
            backtrace(nums, j + 1, rs, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(ReflectUtils.getInstance(Subsets_78.class).subsets(nums));

    }


}
