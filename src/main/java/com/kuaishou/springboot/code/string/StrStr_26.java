package com.kuaishou.springboot.code.string;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-29
 * possible solutions:
 *  KMP: judge the shorter contained in the longer string
 *  Segment Tree: find the common prefix
 */
public class StrStr_26 {

    public static int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) return -1;
        if (haystack.length() < needle.length()) return -1;
        int p = 0; int q = 0; int s = 0;
        char[] ps = haystack.toCharArray();
        char[] ns = needle.toCharArray();

        while (p < ps.length && q < ns.length) {
            if (ps[p] != ns[q]) {
                p = ++s; q = 0;
            } else {
                ++p; ++q;
            }
        }
        if (q == ns.length) return s;
        return -1;
    }

    public static int strStr0(String haystack, String needle) {

        if (haystack == null || needle == null) return -1;
        if (haystack.length() < needle.length()) return -1;
        if (haystack.length() == 0) return 0;

        int p = 0; int q = 0; int s = 0;
        char[] ps = haystack.toCharArray();
        char[] ns = needle.toCharArray();
        int[] next = getNext(ps);


        while (p < ps.length && q < ns.length) {
            if (ps[p] == ns[q]) {
                ++p; ++q;
            } else {
               if (q == 0) ++p;
               else p = next[p];
            }
        }
        if (q == ns.length) return s;
        return -1;
    }

    private static int[] getNext(char[] p) {
        if(p.length == 0) return new int[0];
        int[] next = new int[p.length];
        next[0] = -1;
        int index = -1;
        int i = 0;

        while(i < p.length - 1){

            if(index == -1 || p[i] == p[index])
                next[++i] = ++index;
            else
                index = next[index];
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(strStr("", ""));
    }
}
