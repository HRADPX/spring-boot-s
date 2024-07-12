package com.kuaishou.springboot.code.dp;

import java.util.Arrays;
import java.util.List;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-18
 */
public class WordBreak_139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s.length() <= 0 || wordDict.isEmpty())
            return false;

        int max = 0;
        for(String ss : wordDict) max = Math.max(max,ss.length());

        char[] cs = s.toCharArray();
        boolean[] dp = new boolean[cs.length + 1];
        dp[0] = true;

        for (int i = 0; i < cs.length; i++) {
            for (int j = i; j >= 0 && i - j + 1 <= max; j--) {
                String ss = new String(cs, j, i - j + 1);
                if (wordDict.contains(ss)) {
                    if (dp[j]) {
                        dp[i + 1] = true;
                        break;
                    }
                }
            }
        }
        return dp[cs.length];
    }

    // 完全背包，物品无限，先物后背包，正序遍历
    public boolean wordBreakV1(String s, List<String> wordDict) {

        char[] cs = s.toCharArray();

        int max = Integer.MAX_VALUE;
        for (String ss : wordDict)
            max = Math.min(ss.length(), max);

        boolean[] dp = new boolean[cs.length + 1];
        dp[0] = true;

        // 这里需要注意如果内层不是逆序，不能使用 max 提前终止
        for (int i = 1; i <= cs.length; i++) {
            for (int j = i; j >= 1 && i - j + 1 <= max; j--) {
                if (!dp[i] && wordDict.contains(new String(cs, j - 1, i - j + 1))) {
                    dp[i] |= dp[j - 1];
                }
            }
        }
        return dp[cs.length];
    }


    public static void main(String[] args) {

        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(ReflectUtils.getInstance(WordBreak_139.class)
                .wordBreakV1("leetcode", wordDict));
    }
}
