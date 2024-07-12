package com.kuaishou.springboot.code.window;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-30
 */
public class MinWindow_76 {

    public String minWindow(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        char[] chars = s.toCharArray();
        char[] cs = t.toCharArray();

        int[] ss = new int[128];
        int[] tt = new int[128];
        int count = cs.length;
        Arrays.fill(tt, -1);

        for (char c : cs)
            tt[c] = tt[c] == -1 ? 1 : ++tt[c];


        int left = 0;
        int right = -1;
        int low = 0;
        int high = chars.length;

        for (int i = 0; i < chars.length; i++) {

            ss[chars[i]]++;
            if (ss[chars[i]] <= tt[chars[i]]) count--;

            if (count > 0) continue;

            right = i;
            while (left < right) {

                if (tt[chars[left]] == -1) {
                    left++;
                } else if (ss[chars[left]] > tt[chars[left]]) {
                    ss[chars[left]]--;
                    left++;
                } else {
                    break;
                }
            }
            if (right - left < high - low) {
                high = right;
                low = left;
            }
        }
        return right == -1 ? "" : new String(chars, low, high - low + 1);
    }

    public static void main(String[] args) {
        System.out.println(ReflectUtils.getInstance(MinWindow_76.class).minWindow("ADOBECODEBANC", "ABC"));
    }
}
