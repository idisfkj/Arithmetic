package com.idisfkj.arithmetic.LeetCode;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string
 * by deleting some (can be none) of the characters without
 * disturbing the relative positions of the remaining characters.
 * (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
 * Here is an example:
 * S ="rabbbit", T ="rabbit"
 * Return3.
 * Created by idisfkj on 16/10/7.
 */
public class DistinctSubsequences {
    public int count = 0;

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("rabbbit", "rabbit"));
    }

    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() == 0 || T.length() == 0 || S.length() < T.length())
            return 0;
//        char[] sCh = S.toCharArray();
//        char[] tCh = T.toCharArray();
//        solution(sCh, tCh, 0, 0);
//        return count;

        int[][] dp = new int[S.length() + 1][T.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 0; j <= T.length(); j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[S.length()][T.length()];
    }


    public void solution(char[] sCh, char[] tCh, int sPosition, int tPosition) {
        for (int i = sPosition; i < sCh.length; i++) {
            if (sCh[i] == tCh[tPosition])
                if (tPosition != tCh.length - 1) {
                    solution(sCh, tCh, i + 1, tPosition + 1);
                } else {
                    count++;
                }
        }
    }
}
