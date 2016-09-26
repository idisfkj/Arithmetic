package com.idisfkj.arithmetic.ER2016;

import java.util.Scanner;

/**
 * Created by idisfkj on 16/9/24.
 */
public class MushroomMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int[][] matrix = new int[n][m];
            double[][] dp = new double[n][m];
            for (int i = 0; i < k; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                matrix[x - 1][y - 1] = 1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == 0 && j == 0) {
                        //初始值
                        dp[i][j] = 1;
                    } else if (matrix[i][j] == 1) {
                        //障碍
                        dp[i][j] = 0;
                    }else {
                        dp[i][j] = (j-1<0?0:(i+1<n?dp[i][j-1]*0.5:dp[i][j-1]))+(i-1<0?0:(j+1<m?dp[i-1][j]*0.5:dp[i-1][j]));
                    }
                    // 0 0 0
                    // 0 1 0
                    // 0 0 0
                }
            }
            System.out.println(String.format("%.2f", dp[n - 1][m - 1]));
        }
    }
}
