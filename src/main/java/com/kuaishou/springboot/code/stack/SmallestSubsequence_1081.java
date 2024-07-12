package com.kuaishou.springboot.code.stack;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-15
 */
public class SmallestSubsequence_1081 {

    public static String smallestSubsequence(String s) {

        if (s.length() <= 1) return s;

        char[] cs = s.toCharArray();
        boolean[] mask = new boolean[26];   // 记录个个字符是否已经被选择
        int[] count = new int[26];          // 记录各个字符的个数
        for (char c : cs) count[c - 'a']++;

        int[] stack = new int[cs.length];
        int top = -1;

        // cbacdcbc   bcabc
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            // 已经在堆栈中，并且已经不足
            if (mask[c - 'a'] && --count[c - 'a'] >= -1) continue;
            while (top != -1 && count[cs[stack[top]] - 'a'] > 0 && c < cs[stack[top]]) {
                mask[cs[stack[top--]] - 'a'] = false;
            }
            mask[c - 'a'] = true;
            stack[++top] = i;
            --count[c - 'a'];
        }

        StringBuilder rs = new StringBuilder();

        for (int i = 0; i <= top; i++) {
            rs.append(cs[stack[i]]);
        }

        return rs.toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestSubsequence("bcabc"));

    }
}
