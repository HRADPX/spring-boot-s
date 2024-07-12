package com.kuaishou.springboot.code.doublePos;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-29
 */
public class ValidPalindrome_680 {

    public boolean validPalindrome(String s) {

        char[] cs = s.toCharArray();

        int low = 0, high = cs.length - 1;
        while (low < high) {
            if (cs[low] == cs[high]) {
                low++; high--;
                continue;
            }
            return isPalindrome(cs, low + 1, high) || isPalindrome(cs, low, high - 1);
        }
        return true;
    }

    private boolean isPalindrome(char[] cs, int low, int high) {

        while (low < high) {
            if (cs[low] != cs[high]) {
                return false;
            }
            low++; high--;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(ReflectUtils.getInstance(ValidPalindrome_680.class).validPalindrome("aba"));
        System.out.println(ReflectUtils.getInstance(ValidPalindrome_680.class).validPalindrome("abca"));
        System.out.println(ReflectUtils.getInstance(ValidPalindrome_680.class).validPalindrome("abcd"));
    }
}
