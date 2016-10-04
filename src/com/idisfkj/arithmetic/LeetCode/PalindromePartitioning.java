package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s ="aab",
 * Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * Created by idisfkj on 16/10/4.
 */
public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> result = new ArrayList<>();
    public ArrayList<String> item = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> res = new PalindromePartitioning().partition("adda");
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++)
                System.out.print(res.get(i).get(j) + " ");
            System.out.println();
        }
    }

    public ArrayList<ArrayList<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return result;
        dfs(s, 0);
        return result;
    }

    public void dfs(String s, int pos) {
        int len = s.length();
        if (pos == len) {
            ArrayList<String> copyItem = (ArrayList<String>) item.clone();
            result.add(copyItem);
            return;
        }

        for (int i = pos + 1; i <= len; i++) {
            String str = s.substring(pos, i);
            if (isPalindrome(str)) {
                item.add(str);
                dfs(s, i);
                item.remove(item.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] str = s.toCharArray();
        while (start < end) {
            if (str[start++] == str[end--])
                continue;
            return false;
        }
        return true;
    }
}
