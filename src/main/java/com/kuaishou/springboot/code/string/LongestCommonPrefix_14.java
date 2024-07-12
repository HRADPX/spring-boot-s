package com.kuaishou.springboot.code.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-21
 * 线段树
 */
public class LongestCommonPrefix_14 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        char[] chars = strs[0].toCharArray();
        int idx = 0;
        List<char[]> charList = Arrays.stream(strs).map(String::toCharArray).collect(Collectors.toList());

        outer: while (true) {
            for (char[] cs : charList) {
                if (idx == cs.length) break outer;
                if (chars[idx] != cs[idx]) break outer;
            }
            ++idx;
        }
        return new String(chars,0, idx);
    }

    public static void main(String[] args) {

        String[] strs  = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
