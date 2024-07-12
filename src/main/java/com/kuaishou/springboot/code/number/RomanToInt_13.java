package com.kuaishou.springboot.code.number;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-20
 */
public class RomanToInt_13 {

    public static String[] romanStringArrays = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static int[] intArrays = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static int romanToInt0(String s) {

        int ans = 0;
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = 0; i < romanStringArrays.length; i++) {
            int length = romanStringArrays[i].length();
            while (j < chars.length && j + length <= chars.length && new String(chars, j, length).equals(romanStringArrays[i])) {
                ans += intArrays[i];
                j += length;
            }
        }
        return ans;
    }

    public static int romanToInt(String s) {

        char[] chars = s.toCharArray();
        int ans = 0;
        int preValue = getValue(chars[0]);

        for (int i = 1; i < chars.length; i++) {

            int curValue = getValue(chars[i]);
            if(preValue >= curValue)
                ans += preValue;
            else
                ans -= preValue;
            preValue = curValue;
        }
        ans += preValue;
        return ans;
    }

    private static int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {

        System.out.println(romanToInt0("DCXXI"));
//        System.out.println(romanToInt(IntToRoman_12.intToRoman(4349)));
    }
}
