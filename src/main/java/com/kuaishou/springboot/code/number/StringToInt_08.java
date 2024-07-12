package com.kuaishou.springboot.code.number;

import static com.kuaishou.springboot.code.number.NumberUtils.isNegativeSignal;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-17
 */
public class StringToInt_08 {

    public static int stringToInt(String s) {

        char[] chars = s.toCharArray();
        int i = 0; int signal = 1;
        int res = 0;

        while (i < chars.length && chars[i] == ' ')
            ++i;
        if (i == chars.length) return res;
        if (isSignal(chars[i])) {
            if (isNegativeSignal(chars[i++]))
                signal = -1;
        }
        while (i < chars.length && isNumberChar(chars[i])) {
            // 判断是否超过阈值
            int add = chars[i] - '0';
            if (!isOverLimit(res, add)) {
                return signal == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + add * signal;
            ++i;
        }
        return res;
    }

    public static boolean isNumberChar(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isSignal(char c) {
        return c == '+' || c == '-';
    }

    public static boolean isOverLimit(int res, int add) {
        if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
            return false;
        }
        if (Math.abs(res) == Integer.MAX_VALUE / 10) {
            return res > 0 ? Integer.MAX_VALUE - res * 10 >= add
                           : res * 10 - Integer.MIN_VALUE >= add;
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(stringToInt("-21474836468"));
    }
}
