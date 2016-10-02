package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 * Created by idisfkj on 16/10/2.
 */
public class WordBreakIi {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(s, dict, map);

    }

    public ArrayList<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> map) {
        if (map.containsKey(s))
            return (ArrayList<String>) map.get(s);

        ArrayList<String> lists = new ArrayList();
        if (s.equals(""))
            lists.add("");
        else {
            int len = s.length();
            for (int i = 1; i <= len; i++) {
                String sub = s.substring(0, i);
                if (dict.contains(sub)) {
                    ArrayList t = dfs(s.substring(i, len), dict, map);
                    if (t.size() == 0) {
                        continue;
                    } else {
                        for (int j = 0; j < t.size(); j++) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(sub).append(" ").append(t.get(j));
                            lists.add(sb.toString().trim());

                        }
                    }
                }
            }
        }
        map.put(s, lists);
        return lists;
    }
}
