package com.kuaishou.springboot.code.doublePos;

import java.util.Arrays;
import java.util.List;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-29
 *
 * s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 */
public class FindLongestWord_524 {

    public String findLongestWord(String s, List<String> dictionary) {

        String res = "";

        for (String dic : dictionary) {

            if (dic.length() < res.length() || dic.length() > s.length()) {
                continue;
            }
            if (isSequence(s, dic)) {
                if (dic.length() == res.length()) {
                    res = dic.compareTo(res) < 0 ? dic : res;
                } else {
                    res = dic;
                }
            }
        }
        return res;
    }

    private boolean isSequence(String s, String t) {
        int pos = -1;
        for (int i = 0; i < t.length(); i++) {
            int idx = s.indexOf(t.charAt(i), pos + 1);
            if (idx == -1) {
                return false;
            }
            pos = idx;
        }
        return true;
    }

    private boolean containAllLetter(String s, String dic) {

        int i = 0, j = 0;
        while (i < s.length() && j < dic.length()) {
            if (s.charAt(i) == dic.charAt(j)) {
                j++;
            }
            ++i;
        }
        return j == dic.length();
    }

    public static void main(String[] args) {

        FindLongestWord_524 instance = ReflectUtils.getInstance(FindLongestWord_524.class);

        List<String> dictionaries = Arrays.asList("ale","apple","monkey","cplea");
        System.out.println(instance.findLongestWord("abpcplea", dictionaries));
    }
}
