package com.kuaishou.springboot.code.window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-31
 */
public class FindRepeatedDnaSequences_187 {

    public static List<String> findRepeatedDnaSequences(String s) {

        if (s  == null || s.length() < 10) {
            return Collections.emptyList();
        }

        char[] chars = s.toCharArray();
        Set<Long> containSet = new HashSet<>();
        Set<String> rs = new HashSet<>();

        int left = 0;
        long num = 0;

        for (int i = 0; i < chars.length; i++) {
            num = 10 * num + getMappingNum(chars[i]);
            if (i - left + 1 != 10) {
                continue;
            }
            if (containSet.contains(num)) {
                rs.add(new String(chars, left, 10));
            } else {
                containSet.add(num);
            }
            num = num - (getMappingNum(chars[left]) * (long) Math.pow(10, 9));
            left++;
        }
        return new ArrayList<>(rs);
    }

    private static int getMappingNum(char c) {
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


//        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedDnaSequences("AAGATCCGTCCCCCCAAGATCCGTC"));
    }


}
