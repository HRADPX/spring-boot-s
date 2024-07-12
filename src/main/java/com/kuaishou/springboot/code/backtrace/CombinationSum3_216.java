package com.kuaishou.springboot.code.backtrace;

import java.util.ArrayList;
import java.util.List;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-20
 */
public class CombinationSum3_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> rs = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        backtrace(k, n, 1, rs, list);
        return rs;
    }

    private void backtrace(int k, int n, int idx, List<List<Integer>> rs, List<Integer> list) {

        if (n == 0 && list.size() == k) {
            rs.add(new ArrayList<>(list));
        }
        for (int i = idx; i < 10 && list.size() + 11 - i >= k; i++) {

            if (n < i) break;
            n -= i;
            list.add(i);
            backtrace(k, n, i + 1, rs, list);
            list.remove(list.size() - 1);
            n += i;
        }
    }

    public static void main(String[] args) {

        System.out.println(ReflectUtils.getInstance(CombinationSum3_216.class).combinationSum3(4, 1));
    }
}
