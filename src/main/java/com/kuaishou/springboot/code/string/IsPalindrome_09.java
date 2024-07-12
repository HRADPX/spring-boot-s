package com.kuaishou.springboot.code.string;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-20
 */
public class IsPalindrome_09 {

    public static boolean isPalindrome(int x) {

        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;

        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return x == res || x == res / 10;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome(10001));
    }
}
