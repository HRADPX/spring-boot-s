package com.kuaishou.springboot.code.binarySearch;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-28
 */
public class NextGreatestLetter_744 {

    public char nextGreatestLetter(char[] letters, char target) {

        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = (l + h) >>> 1;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }

    public static void main(String[] args) {

        char[] letters = {'x', 'x', 'y', 'y'};
        System.out.println(ReflectUtils.getInstance(NextGreatestLetter_744.class).nextGreatestLetter(letters, 'z'));
    }
}
