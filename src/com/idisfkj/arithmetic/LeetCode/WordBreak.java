package com.idisfkj.arithmetic.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 * Return true because"leetcode"can be segmented as"leet code".
 * Created by idisfkj on 16/10/2.
 */
public class WordBreak {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("aaaa");
        dict.add("aaa");
        System.out.println(new WordBreak().wordBreak("aaaaaaa", dict));
    }

    //dp[i] = dp[j] && dp[j,i]; j<i
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (flag[j] && dict.contains(s.substring(j, i))) {
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }
}

