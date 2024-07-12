package com.kuaishou.springboot.code.string;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-16
 */
public class LongestPalindrome_05 {

    public static String longestPalindrome$(String s) {

        if (s == null || s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[][] array = new boolean[n + 1][n + 1];
        int max = 0;
        int start = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (chars[i - 1] == chars[j - 1] && (i - j <= 2 || array[j + 1][i - 1])) {
                    array[j][i] = true;
                    if (i - j + 1 > max) {
                        max = i - j + 1;
                        start = j - 1;
                    }
                }
            }
        }
        return new String(chars, start, max);
    }

    public static String longestPalindrome0(String s) {

        if (s == null || s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int start = 0; int end = 0;

        for (int i = 0; i < chars.length; i++) {

            int leftMax = longestPalindrome(chars, i - 1, i + 1);
            if (leftMax > end - start + 1) {
                start = i - leftMax / 2;
                end = i + leftMax / 2;
            }
            int rightMax = longestPalindrome(chars, i, i + 1);
            if (rightMax > end - start + 1) {
                start = i - rightMax / 2 + 1;
                end = i + rightMax / 2;
            }
        }
        return new String(chars, start, end - start + 1);
    }

    public static int longestPalindrome(char[] chars, int left, int right) {

        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    /**
     * @see #longestPalindrome0(String)
     */
    public static String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0; int end = 0; int lo = 0; int hi = 0;

        for (int i = 0; i < (n << 1) - 1; i++) {

            if((i & 1) == 0)
                start = end = i >> 1;
            else {
                start = i >> 1;
                end = start + 1;
            }
            while(start >= 0 && end < n && chars[start] == chars[end]){
                --start;
                ++end;
            }
            int len = end - start - 1;
            if(len > hi - lo + 1){
                hi = (i + len) >> 1;
                lo = (i - len + 1) >> 1;
            }
        }
        return new String(chars, start, end - start + 1);
    }


    public static void main(String[] args) {

        String s = "abba";
        System.out.println(longestPalindrome(s));
    }
}
