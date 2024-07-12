package com.kuaishou.springboot.code.backtrace;

import com.kuaishou.springboot.code.mark.Mark;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-10
 * 最长有效括号
 *  ")()())" —> 4
 */
public class LongestValidParentheses_32 implements Mark {

    public static int longestValidParentheses(String s) {

        if(s.length() <= 1) return 0;
        int left = 0, right = 0;
        char[] cs = s.toCharArray();
        int ans = 0;
        for(int i = 0; i < cs.length; i++){

            if(cs[i] == '(') ++left;
            else ++right;
            if(left == right) ans = Math.max(ans,(left << 1));
            if(right > left) left = right = 0;
        }

        left = right = 0;
        for(int i = cs.length - 1; i >= 0; i--){

            if(cs[i] == ')') ++right;
            else ++left;
            if(left == right) ans = Math.max(ans,(left << 1));
            if(left > right) left = right = 0;
        }
        return ans;
    }

    public static int longestValidParentheses0(String s) {

        if (s.length() <= 1)
            return 0;
        char[] cs = s.toCharArray();
        int ans = 0;
        int[] dp = new int[cs.length];
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == '(') continue;
            // 形如 ........()
            if (cs[i - 1] == '(') dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
            // 形如 ........))
            else if (i - dp[i - 1] - 1 >= 0 && cs[i - dp[i - 1] - 1] == '(')
                dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {

        String s = "(()()";
        System.out.println(longestValidParentheses0(s));
    }
}
