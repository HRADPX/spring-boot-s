package com.kuaishou.springboot.code.window;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-31
 */
public class LengthOfLongestSubstring_3 {

    // abcabcbb  --> abc
    // bbb  -> b
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() < 1) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int[] map = new int[128];
        Arrays.fill(map, -1);

        int rs = -1;
        int left = 0;

        for (int i = 0; i < chars.length; i++) {

            if (map[chars[i]] != -1) {
                // 从当前位置到 bound 都要 abort
                int bound = left;
                left = map[chars[i]] + 1;
                int right = map[chars[i]] - 1;
                while (right >= bound) {
                    map[chars[right--]] = -1;  // reset
                }
            }
            map[chars[i]] = i;
            rs = Math.max(rs, i - left + 1);
        }

        return rs == -1 ? chars.length : rs;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcdc"));
    }
}
