package com.idisfkj.arithmetic.LeetCode;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s ="aab",
 * Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 * Created by idisfkj on 16/10/3.
 */
public class PalindromePartitioningii {
    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningii().minCut("uuysgaww"));
        System.out.println(new PalindromePartitioningii().isPalindrome("uu"));
    }

    public int minCut(String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = isPalindrome(s.substring(0, i + 1)) ? 0 : i;
            if (dp[i] == 0)
                continue;
            for (int j = 1; j <= i; j++) {
                if (isPalindrome(s.substring(j, i + 1))) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                } else {
                    dp[i] = Math.min(dp[i], dp[j - 1] + i - j + 1);
                }
            }
        }
        return dp[s.length() - 1];
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
