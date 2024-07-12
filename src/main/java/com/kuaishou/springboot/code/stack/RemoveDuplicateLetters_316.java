package com.kuaishou.springboot.code.stack;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-13
 */
public class RemoveDuplicateLetters_316 {

    public static String removeDuplicateLetters(String s) {
        if (s.length() <= 1) return s;
        boolean[] mask = new boolean[s.length()];
        char[] cs = s.toCharArray();
        int[] count = new int[26];

        int[] stack = new int[cs.length];
        int top = -1;

        for (char c : cs) ++count[c - 'a'];

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (mask[c - 'a'] && --count[c - 'a'] >= -1) continue;
            while (top != -1 && count[cs[stack[top]] - 'a'] > 0 && c < cs[stack[top]])
                mask[cs[stack[top--]] - 'a'] = false;
            --count[c - 'a'];
            stack[++top] = i;
            mask[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(cs[stack[i]]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }
}
