package com.kuaishou.springboot.code.array;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-11
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */
public class CountAndSay_38 {

    public static String countAndSay(int n) {

        if (n == 1) return "1";
        String preStr = countAndSay(n - 1);
        char[] chars = preStr.toCharArray();
        StringBuilder ans = new StringBuilder();
        int num = 1;
        int idx = 0;
        while (idx < chars.length) {
            if (idx + 1 < chars.length && chars[idx] == chars[idx + 1]) {
                idx++; num++;
            } else {
                ans.append(num).append(chars[idx++]);
                num = 1;
            }
        }
        return ans.toString();
    }

    public static String countAndSay0(int n) {

        if (n == 1) return "1";
        String preStr = countAndSay(n - 1);
        char[] chars = preStr.toCharArray();
        StringBuilder ans = new StringBuilder();
        int count = 1;
        char c = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == c) ++count;
            else {
                ans.append(count).append(c);
                count = 1;
                c = chars[i];
            }
        }
        ans.append(count).append(chars[chars.length - 1]);
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay0(30).length());
    }
}
