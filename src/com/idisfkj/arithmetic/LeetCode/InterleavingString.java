package com.idisfkj.arithmetic.LeetCode;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 ="aabcc",
 * s2 ="dbbca",
 * When s3 ="aadbbcbcac", return true.
 * When s3 ="aadbbbaccc", return false.
 * <p>
 * Created by idisfkj on 16/10/10.
 */
public class InterleavingString {

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("", "abc", "ab"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] ch3 = s3.toCharArray();
        //dp[i][j]代表s1前i个数s2前j个数 所组成的数在s3中的位置,不存在则为-1;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 0;
        //s1 0~length s2 0
        for (int i = 1; i <= ch1.length; i++) {
            if (dp[i - 1][0] != -1 && dp[i - 1][0] < ch3.length)
                dp[i][0] = ch3[dp[i - 1][0]] == ch1[i - 1] ? i : -1;
            else dp[i][0] = -1;
        }

        //s1 0  s2 0~length
        for (int j = 1; j <= ch2.length; j++) {
            if (dp[0][j - 1] != -1 && dp[0][j - 1] < ch3.length)
                dp[0][j] = ch3[dp[0][j - 1]] == ch2[j - 1] ? j : -1;
            else dp[0][j] = -1;
        }


        //s1 1~lenght s2 1~lenght
        for (int i = 1; i <= ch1.length; i++) {
            for (int j = 1; j <= ch2.length; j++) {
                if (dp[i][j - 1] != -1 && dp[i][j - 1] < ch3.length)
                    dp[i][j] = ch3[dp[i][j - 1]] == ch2[j - 1] ? i + j : -1;
                else if (dp[i - 1][j] != -1 && dp[i - 1][j] < ch3.length)
                    dp[i][j] = ch3[dp[i - 1][j]] == ch1[i - 1] ? i + j : -1;
                else dp[i][j] = -1;
            }
        }

        if (dp[s1.length()][s2.length()] == s3.length())
            return true;
        else
            return false;
    }
}
