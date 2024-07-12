package com.kuaishou.springboot.code.window;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-30
 */
public class CheckInclusion_567 {

    public boolean checkInclusion(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s2.length() < s1.length()) {
            return false;
        }
        char[] chars = s2.toCharArray();

        int[] ss = new int[128];
        int[] tt = new int[128];

        for (char c : s1.toCharArray())
            ++tt[c];

        int left = 0;
        int right;
        int count = s1.length();

        for (int i = 0; i < chars.length; i++) {

            if (tt[chars[i]] > 0) {
                ss[chars[i]]++;
                if (ss[chars[i]] <= tt[chars[i]]) count--;
            }
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
            if (right - left + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(ReflectUtils.getInstance(CheckInclusion_567.class).checkInclusion("ab", "eidbxaooo"));
    }
}
