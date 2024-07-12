package com.kuaishou.springboot.code.stack;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-13
 */
public class RemoveKdigits_402 {

    public static String removeKdigits(String num, int k) {

        if (num.length() <= k) {
            return "0";
        }
        char[] cs = num.toCharArray();
        int[] stack = new int[cs.length];
        int top = -1;
        int n = cs.length;

        for (int i = 0; i < cs.length; i++) {
            while (top != -1 && n - i + top + 1 > n - k && cs[i] < cs[stack[top]])
                --top;
            // 到达上限
            if (top + 1 <= n - k - 1) {
                stack[++top] = i;
            }
        }
        int i = 0;
        while (i <= top && cs[stack[i]] == '0') ++i;

        StringBuilder sb = new StringBuilder();
        for (int j = i; j <= top; j++) sb.append(cs[stack[j]]);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String s = "10112";
        System.out.println(removeKdigits(s, 1));
    }
}
