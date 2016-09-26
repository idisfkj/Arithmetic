package com.idisfkj.arithmetic.ER2016;

/**
 * 直方图内最大矩形
 * 有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。
 * 比如，对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
 * Created by idisfkj on 16/9/24.
 */
public class MaxInnerRec {

    public static void main(String[] args) {
        int[] A = new int[]{2, 7, 9, 4, 1};
        System.out.println(new MaxInnerRec().countArea(A, 5));
    }

    public int countArea(int[] A, int n) {
        // write code here
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = A[i];
        }
        int result = 0;
        for (int j = 0; j < n; j++) {
            for (int k = j; k < n; k++) {
                if (k > j)
                    dp[j][k] = (k - j + 1) * Math.min(dp[j][k - 1] / (k - j), dp[k][k]);
                if (dp[j][k] > result)
                    result = dp[j][k];
            }
        }
        return result;
    }
}
