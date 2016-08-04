package com.idisfkj.arithmetic.dp;

/**
 * 平面上有N*M个格子，每个格子中放着一定数量的苹果。
 * 你从左上角的格子开始， 每一步只能向下走或是向右走，每次走到一个格子上就把格子里的苹果收集起来， 这样下去，你最多能收集到多少个苹果
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
