package com.idisfkj.arithmetic.dp;

/**
 * Created by idisfkj on 16/8/2.
 */
public class FindApple {

    public static int findApple(int[][] a, int n, int m) {
        int[][] A = new int[n][m];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0 && j > 0) {
                    temp = Math.max(A[i][j - 1], A[i - 1][j]);
                } else if (i > 0) {
                    temp = A[i - 1][j];
                } else if (j > 0) {
                    temp = A[i][j - 1];
                }
                A[i][j] = a[i][j] + temp;
            }
        }
        return A[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{2, 4, 3}, {3, 6, 8}, {6, 3, 2}};
        int num = findApple(a, a.length, a[0].length);
        System.out.println(num);
    }
}
