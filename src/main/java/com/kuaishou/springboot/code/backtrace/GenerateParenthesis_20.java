package com.kuaishou.springboot.code.backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-24
 */
public class GenerateParenthesis_20 {

    public static List<String> generateParenthesis(int n) {

        if (n <= 0) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        char[] chars = new char[n << 1];
        generateParenthesis(0, 0, 0, chars, result);
        return result;
    }

    private static void generateParenthesis(int left, int right, int index, char[] chars, List<String> result) {

        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        if (left < right) return;
        if (left < chars.length / 2) {
            chars[index] = '(';
            generateParenthesis(left + 1, right, index + 1, chars, result);
        }
        if (right < chars.length / 2) {
            chars[index] = ')';
            generateParenthesis(left, right + 1, index + 1, chars, result);
        }
    }

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }
}
