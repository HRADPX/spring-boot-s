package com.kuaishou.springboot.code.backtrace;

import java.util.ArrayList;
import java.util.List;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-20
 */
public class Combine_77 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> rs = new ArrayList<>();
        if (k <= 0 || n < k) {
            return rs;
        }
        List<Integer> list = new ArrayList<>();

        backtrace(n, 1, k, rs, list);
        return rs;
    }

    private void backtrace(int n, int index, int k, List<List<Integer>> rs, List<Integer> list) {

        if (list.size() == k) {
            rs.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n && list.size() + n - i + 1 >= k; i++) {
            list.add(i);
            backtrace(n, i + 1, k, rs, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(ReflectUtils.getInstance(Combine_77.class).combine(4, 3));

    }
}
