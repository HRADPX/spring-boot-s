package com.kuaishou.springboot.code.number;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-29
 * 不使用乘法、除法和 mod 运算符。
 */
public class Divide_29 {

    public static int divide(int dividend, int divisor) {

        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) return 1;
        if (divisor == Integer.MIN_VALUE) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == -1) return -dividend;
        if (divisor == 1) return dividend;

        boolean flag = false;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) flag = true;

        int prefix = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor > 0) {
                dividend += divisor;
                prefix = -1;
            } else {
                dividend -= divisor;
                prefix = 1;
            }
        }
        dividend = dividend > 0 ? dividend : -dividend;
        divisor = divisor > 0 ? divisor : -divisor;
        if (dividend < divisor) return prefix;

        int res = 0;
        while (dividend >= divisor) {
            int sum = divisor;
            int count = 1;
            while ((dividend >> 1) >= sum) {
                sum <<= 1;
                count <<= 1;
            }
            dividend -= sum;
            res += count;
        }
        return (flag ? -res : res) + prefix;
    }

    public static void main(String[] args) {

        System.out.println(Integer.MIN_VALUE);
        System.out.println(divide(Integer.MIN_VALUE, -2));
    }
}
