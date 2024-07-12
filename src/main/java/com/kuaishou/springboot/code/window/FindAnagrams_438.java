package com.kuaishou.springboot.code.window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-31
 */
public class FindAnagrams_438 {

    public static List<Integer> findAnagrams(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return Collections.emptyList();
        }

        List<Integer> rs = new ArrayList<>();
        char[] chars = s.toCharArray();

        int[] ss = new int[128];
        int[] tt = new int[128];

        for (char c : t.toCharArray())
            tt[c]++;

        int left = 0;
        int right;
        int count = t.length();

        for (int i = 0; i < chars.length; i++) {

            if (++ss[chars[i]] <= tt[chars[i]]) count--;
            if (count > 0) continue;

            right = i;

            while (left < right) {

                if (tt[chars[left]] == 0) {
                    left++;
                } else if (ss[chars[left]] > tt[chars[left]]) {
                    ss[chars[left]]--;
                    left++;
                } else {
                    break;
                }
            }
            if (right - left + 1 == t.length()) {
                rs.add(left);
            }
        }
        return rs;
    }

    public static void main(String[] args) {

        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
