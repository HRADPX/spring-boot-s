package com.kuaishou.springboot.code.doublePos;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-24
 */
public class LongestPalindrome_5 {

    public String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }
        int startIdx = 0;
        int max = 0;
        // babad
        char[] chars = s.toCharArray();

        for (int i = 0; i < (chars.length * 2 - 1); i++) {

            int low = i >>> 1;
            int high = (i + 1) >>> 1;
            // 其实方法可以返回前后下标或者直接返回回文串，这样不用计算 startIdx，实现起来更加容易
            int rs = longestPalindrome(chars, low, high);
            if (rs > max) {
                startIdx = low - ((rs - 1) >> 1);
                max = rs;
            }
        }
        return new String(chars, startIdx, max);
    }

    private int longestPalindrome(char[] cs, int low, int high) {

        while (low >= 0 && high < cs.length && cs[low] == cs[high]) {
            low--;
            high++;
        }
        return high - low - 1;
    }

    public static void main(String[] args) {
        String s = "cccdddcc";
        System.out.println(ReflectUtils.getInstance(LongestPalindrome_5.class).longestPalindrome(s));
    }

}
