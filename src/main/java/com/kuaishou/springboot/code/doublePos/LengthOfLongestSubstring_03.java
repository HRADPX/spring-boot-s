package com.kuaishou.springboot.code.doublePos;

import org.apache.commons.lang3.StringUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-16
 */
public class LengthOfLongestSubstring_03 {

    public static String longestSubstring(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int[] array = new int[128];
        int slow = 0; int fast;
        int start = 0; int max = 0;
        for (fast = 0; fast < chars.length; fast++) {
            if (++array[chars[fast]] > 1) {
                while (slow <= fast && array[chars[fast]] > 1) {
                    --array[chars[slow++]];
                }
            }
            if (fast == chars.length - 1 && fast - slow + 1 <= max) {
                break;
            }
            if (fast - slow + 1 > max) {
                max = fast - slow + 1;
                start = slow;
            }
        }
        return new String(chars, start, max);
    }

    public static int lengthOfLongestSubstring(String s) {
        return StringUtils.defaultString(longestSubstring(s)).length();
    }

    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(longestSubstring(s));
    }
}
