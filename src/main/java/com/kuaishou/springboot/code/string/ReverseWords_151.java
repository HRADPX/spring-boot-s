package com.kuaishou.springboot.code.string;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-29
 */
public class ReverseWords_151 {

    public String reverseWords(String s) {

        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int low = 0;
        int high = chars.length - 1;

        while (low <= high && chars[low] == ' ') low++;
        while (high >= low && chars[high] == ' ') high--;
        int idx = 0;
        boolean space = true;

        for (int i = low; i <= high; i++) {
            if (space && chars[i] == ' ') continue;

            if (chars[i] == ' ') {
                chars[idx++] = ' ';
                space = true;
            } else {
                chars[idx++] = chars[i];
                space = false;
            }
        }
        idx--;

        System.out.println(new String(chars, 0, idx + 1));
        System.out.println(new String(chars, 0, idx + 1).length());

        low = 0;
        for (int i = 0; i <= idx; i++) {
            if (chars[i] != ' ') continue;
            this.reverse(chars, low, i - 1);
            low = i + 1;
        }
        this.reverse(chars, low, idx);

        this.reverse(chars, 0, idx);
        return new String(chars, 0, idx + 1);
    }

    public void reverse(char[] chars, int low, int high) {

        while (low < high) {
            char c = chars[low];
            chars[low] = chars[high];
            chars[high] = c;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {

        System.out.println(
                ReflectUtils.getInstance(ReverseWords_151.class).reverseWords("the sky is blue hacc "));
    }
}
