package com.kuaishou.springboot.code.string;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-17
 */
public class Convert_06 {

    public static String convert(String s, int numRows) {

        if (s == null || s.length() <= 1 || numRows <= 1)
            return s;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int interval = (numRows - 1) << 1;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < chars.length; j += interval) {
                sb.append(chars[j]);
                if (i != 0 && i != numRows - 1) {
                    int idx = j + (numRows - i - 1) * 2;
                    if (idx < chars.length)
                        sb.append(chars[idx]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 4));
    }
}
