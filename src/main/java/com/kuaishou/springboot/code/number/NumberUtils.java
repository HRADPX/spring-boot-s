package com.kuaishou.springboot.code.number;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-17
 */
public class NumberUtils {

    private static final char POSITIVE_SIGNAL = '+';
    private static final char NEGATIVE_SIGNAL = '-';
    public static final char WHITE_SPACE = ' ';

    public static boolean isNumberChar(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isNonNumberChar(char c) {
        return !isNumberChar(c);
    }

    public static int charToInt(char c) {
        return isNumberChar(c) ? c - '0' : 0;
    }

    public static <T> void reverseArray(T[] array) {
        if (ArrayUtils.isEmpty(array)) return;
        int low = 0; int high = array.length - 1;
        while (low < high) {
            T temp = array[low];
            array[low++] = array[high];
            array[high--] = temp;
        }
    }

    public static void reverseArray(char[] chars) {
        if (ArrayUtils.isEmpty(chars)) return;
        int low = 0; int high = chars.length - 1;
        while (low < high) {
            char temp = chars[low];
            chars[low++] = chars[high];
            chars[high--] = temp;
        }
    }

    public static boolean isSignal(char c) {
        return c == POSITIVE_SIGNAL || c == NEGATIVE_SIGNAL;
    }

    public static boolean isPositiveSignal(char c) {
        return c == POSITIVE_SIGNAL;
    }

    public static boolean isNegativeSignal(char c) {
        return c == NEGATIVE_SIGNAL;
    }
}
