package com.kuaishou.springboot.code.doublePos;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-29
 */
public class JudgeSquareSum_633 {

    public boolean judgeSquareSum(int c) {

        if (c <= 1) {
            return true;
        }
        int low = 0, high = (int) Math.sqrt(c);

        while (low <= high) {
            // 这里使用加法会溢出
            int s = c - low * low;
            int t = high * high;
            if (s == t) {
                return true;
            }
            if (s > t) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(ReflectUtils.getInstance(JudgeSquareSum_633.class).judgeSquareSum(2147483600));
    }
}
