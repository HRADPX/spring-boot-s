package com.kuaishou.springboot.code.window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-14
 */
public class FindRepeatedDnaSequencesV1_187 {


    // "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    public static List<String> findRepeatedDnaSequences(String s) {

        if (s == null || s.length() < 10) {
            return Collections.emptyList();
        }
        char[] cs = s.toCharArray();

        Set<Long> contains = new HashSet<>();
        Set<String> result = new HashSet<>();
        int left = 0;
        int right = 0;
        long num = 0;


        while (right < cs.length) {
            num = 10 * num + getMapping(cs[right]);
            if (right - left + 1 != 10) {
                right++;
                continue;
            }
            // distance = 10
            if (contains.contains(num)) {
                result.add(new String(cs, left, 10));
            }
            contains.add(num);
            num -= getMapping(cs[left++]) * (long) Math.pow(10, 9);
            right++;
        }
        return new ArrayList<>(result);
    }


    private static int getMapping(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {

        String s = "AAAAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }
}
