package com.kuaishou.springboot.code.number;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-20
 */
public class IntToRoman_12 {

    public static String[] romanStringArrays = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static int[] intArrays = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String intToRoman(int num) {

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < intArrays.length; i++) {
            int k = num / intArrays[i];
            while (k-- > 0) ans.append(romanStringArrays[i]);
            num %= intArrays[i];
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
