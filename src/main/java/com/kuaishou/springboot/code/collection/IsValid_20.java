package com.kuaishou.springboot.code.collection;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-24
 */
public class IsValid_20 {

    public static boolean isValid(String s) {
        if (s == null || (s.length() & 1) == 1)
            return false;
        char[] chars = s.toCharArray();
        char[] stack = new char[chars.length];
        int index = -1;

        for (int i = 0; i < chars.length; i++) {
            if (index >= 0 && isMatch(stack[index], chars[i]))
                --index;
            else
                stack[++index] = chars[i];
        }
        return index == -1;
    }

    private static boolean isMatch(char c, char match) {
        switch (c) {
            case '(': return match == ')';
            case '{': return match == '}';
            case '[': return match == ']';
            default: return false;
        }
    }

    public static void main(String[] args) {

        String s = "{}";
        System.out.println(isValid(s));
    }
}
