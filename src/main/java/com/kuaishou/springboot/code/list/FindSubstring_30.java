package com.kuaishou.springboot.code.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-30
 */
public class FindSubstring_30 {

    public static List<Integer> findSubstring(String s, String[] words) {

        if (s == null || s.length() <= 0) return Collections.emptyList();
        if (words == null || words.length <= 0) return Collections.emptyList();

        char[] chars = s.toCharArray();
        List<Integer> result = new ArrayList<>();
        boolean[] flag = new boolean[words.length];
        int step = words[0].length();
//        findSubstring(chars, 0, words, result);
        return result;

    }

    private static void findSubstring(char[] chars, int start, String[] words, int step, List<Integer> result) {


        for (int i = 0; i < words.length; i++) {
            findSubstring(chars, start + step, words, step, result);
        }

    }
}
