package com.kuaishou.springboot.code.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-18
 */
public class WordBreak_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {

        if (s.length() <= 0 || wordDict.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, List<String>> cache = new HashMap<>();
        return wordBreak(s, wordDict, cache);
    }

    private List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> cache) {

        if (cache.containsKey(s)) return cache.get(s);
        List<String> ans = new ArrayList<>();
        if (wordDict.contains(s)) {
            ans.add(s);
        }
        for (int i = 0; i < s.length(); i++) {
            String ss = s.substring(0, i + 1);
            if (!wordDict.contains(ss)) {
                continue;
            }
            ans.add(ss);
            List<String> list = wordBreak(s.substring(i + 1), wordDict, cache);
            for (String string : list)
                ans.add(ss + ' ' + string);
        }
        cache.put(s, ans);
        return ans;
    }

    private List<String> wordBreakV1(String s, List<String> wordDic, Map<String, List<String>> cache) {
        if (cache.containsKey(s)) return cache.get(s);
        List<String> ans = new ArrayList<>();
        if (wordDic.contains(s)) {
            ans.add(s);
        }
        for (int i = 0; i < s.length(); i++) {
            String ss = s.substring(0, i + 1);
            if (!wordDic.contains(ss)) {
                continue;
            }
            ans.add(ss);
            List<String> list = wordBreakV1(s.substring(i + 1), wordDic, cache);
            for (String s1 : list) {
                ans.add(ss + " " + s1);
            }
        }
        cache.put(s, ans);
        return ans;
    }
}
