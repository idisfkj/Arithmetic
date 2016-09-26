package com.idisfkj.arithmetic.ER2016;

import java.util.Scanner;

/**
 * 罪犯转移
 * Created by idisfkj on 16/9/24.
 */
public class CrimeTransfer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int t = in.nextInt();
            int c = in.nextInt();
            int[] crime = new int[n];
            for (int i = 0; i < n; i++) {
                crime[i] = in.nextInt();
            }
            int temp = 0;
            for (int j = 0; j < c; j++) {
                temp += crime[j];
            }
            int count = 0;
            if (temp <= t)
                count++;
            for (int k = c; k < n; k++) {
                temp = temp + crime[k] - crime[k - c];
                if (temp <= t)
                    count++;
            }
            System.out.println(count);
        }

//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            crime[i] = in.nextInt();
//            dp[i][i] = crime[i];
//        }
//        int temp = 0;
//        for (int i = 0; i < c; i++) {
//            temp += crime[i];
//        }
//        if (temp <= t)
//            dp[0][c - 1] = 1;
//
//        for (int j = c; j < n; j++) {
//            dp[0][j] = dp[0][j - 1] + ((dp[j - 1][j - 1] + dp[j][j]) <= t ? 1 : 0);
//        }
//        System.out.println(dp[0][n - 1]);
    }
}
