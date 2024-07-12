package com.kuaishou.springboot.code.array;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-17
 *
 * 316，321，402，1081
 */
public class RemoveDuplicateLetters_316 {

    // cbacdcbc
    public String removeDuplicateLetters(String s) {

        if (s.length() <= 1)
            return s;

        char[] cs = s.toCharArray();
        int[] counts = new int[26];
        boolean[] mask = new boolean[26];
        for (char c : cs) counts[c - 'a']++;

        int[] stack = new int[cs.length];
        int top = -1;

        for (int i = 0; i < cs.length; i++) {
            if (mask[cs[i] - 'a'] && --counts[cs[top] - 'a'] >= -1) continue;
            while (top != -1 && cs[i] < cs[stack[top]] && --counts[cs[top] - 'a'] > 0) {
                mask[cs[stack[top]] - 'a'] = false;
                top--;
            }
            stack[++top] = i;
            mask[cs[i] - 'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= top; i++) res.append(cs[stack[i]]);

        return res.toString();
    }

    public static void main(String[] args) {

        String s = "cbacdcbc";
        System.out.println(ReflectUtils.getInstance(RemoveDuplicateLetters_316.class).removeDuplicateLetters(s));

    }
}
