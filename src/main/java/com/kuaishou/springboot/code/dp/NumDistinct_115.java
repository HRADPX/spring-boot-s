package com.kuaishou.springboot.code.dp;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-05
 */
public class NumDistinct_115 {

    // babgbag  bag
    int rs;
    public int numDistinct(String s, String t) {

        if (s.length() < t.length()) return 0;

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        // dp[i][j] 表示 s 的前 i 个字符，t 的前 j 个字符有多少包含关系
        int[][] dp = new int[cs.length][ct.length];

        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < ct.length; j++) {
                dp[i][j] = -1;
            }
        }
//        return backtrace(cs, 0, ct, 0, dp);
        return 0;
    }

    // 回溯超时
    private void backtrace(char[] cs, int i, char[] ct, int j, int[][] dp) {
        if (dp[i][j] != -1)
        if (j == ct.length) {
            rs++;
            return;
        }
        for (int k = i; k < cs.length && cs.length - k >= ct.length - j; k++) {
            if (cs[k] != ct[j]) continue;
            backtrace(cs, k + 1, ct, j + 1, dp);
        }
    }

    public static void main(String[] args) {
        System.out.println(ReflectUtils.getInstance(NumDistinct_115.class).numDistinct("babgbag", "bag"));
    }
}
