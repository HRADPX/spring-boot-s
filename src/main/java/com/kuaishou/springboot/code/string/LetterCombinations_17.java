package com.kuaishou.springboot.code.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-22
 */
public class LetterCombinations_17 {

    private static Map<Character, List<Character>> map;

    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0)
            return Collections.emptyList();
        initLetterMap();
        List<String> result = new ArrayList<>();
        char[] chars = digits.toCharArray();
        char[] cs = new char[chars.length];
        letterCombinations(chars, 0, cs, result);

        return result;
    }

    private static void letterCombinations(char[] chars, int i, char[] cs, List<String> result) {
        if (i == cs.length) {
            result.add(new String(cs));
            return;
        }
        for (Character character : map.get(chars[i])) {
            cs[i] = character;
            letterCombinations(chars, i + 1, cs, result);
        }
    }

    private static void initLetterMap() {

        if (map == null) map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public static void main(String[] args) {


        String s = "23";
        System.out.println(letterCombinations(s));
    }
}
