package com.idisfkj.arithmetic.LeetCode;

/**
 * A message containing letters fromA-Zis being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
 * The number of ways decoding"12"is 2.
 * <p>
 * Created by idisfkj on 16/10/14.
 */
public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("110"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        // 1120
        // 0  0
        // 1  1   1
        // 2  2   1,2 12
        // 3  3   1,2,1 12,1 1,21
        // 4  2   1,2,1,2 12,1,2 1,21,2 1,2,12 12,12
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            //当前值为0
            if (s.substring(i, i + 1).equals("0")) {
                //与前一个数能够进行组合在一起
                if (!s.substring(i - 1, i).equals("0") && Integer.parseInt(s.substring(i - 1, i)) <= 2) {
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
            } else if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
                //前一个数为0与当前数不能进行组合
                if (s.charAt(i - 1) == '0') {
                    dp[i + 1] = dp[i];
                } else if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                    //前一个数能与当前数进行组合
                    dp[i + 1] = dp[i] + dp[i - 1];
                } else {
                    //前一个数不为0但又不能与当前数进行组合
                    dp[i + 1] = dp[i];
                }
            } else {
                return 0;
            }
        }
        return dp[s.length()];
    }
}
