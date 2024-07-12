package com.kuaishou.springboot.code.window;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-15
 */
public class StrStr_28 {

    public int strStr(String haystack, String needle) {

//        if (haystack.length() == 0 || needle.length() == 0 || haystack.length() < needle.length()) {
//            return -1;
//        }
//        char[] cc = haystack.toCharArray();
//        char[] pp = needle.toCharArray();
//        long mod = 1658598167;
//        long match = 0;
//        int left = 0;
//        long window = 0;
//
//        for (char c : pp) match = (match * 256 + c) % mod;
//
//        for (int i = 0; i < cc.length; i++) {
//            window = (window * 256 + cc[i]) % mod;
//            if (i - left + 1 != pp.length) {
//                continue;
//            }
//            if (window == match && needle.equals(new String(cc, left, pp.length))) {
//                return left;
//            }
//            window
//        }
        return -1;
    }
}
