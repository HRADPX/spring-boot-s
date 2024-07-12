package com.kuaishou.springboot.code.string;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-11
 */
public class Multiply_43 {

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        int[] res = new int[cs1.length + cs2.length];
        int bit = 0;

        for (int i = cs1.length - 1; i >= 0; i--) {
            bit = 0;
            for (int j = cs2.length - 1; j >= 0; j--) {
                int value = (res[i + j + 1] + (cs1[i] - '0') * (cs2[j] - '0') + bit);
                bit = value / 10;
                res[i + j + 1] = value % 10;
            }
            res[i] = bit;
        }
        StringBuilder ans = new StringBuilder();
        int idx = 0;
        while (idx < res.length && res[idx] == 0) ++idx;
        for (int i = idx; i < res.length; i++) {
            ans.append(res[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("1234", "5678"));
        System.out.println(1234*5678);
    }
}
