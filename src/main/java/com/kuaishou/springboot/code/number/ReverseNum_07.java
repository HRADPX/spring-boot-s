package com.kuaishou.springboot.code.number;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-17
 */
public class ReverseNum_07 {

    public static int reverse(int x) {

        int res = 0;
        while (x != 0) {
            if (res * 10 / 10 != res) {
                res = 0;
                break;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public static int reverse0(int x) {

        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10)
                return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse0(-1534236469));
        System.out.println(reverse(-1534236469));
    }
}
