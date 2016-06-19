package com.idisfkj.arithmetic.search;

/**
 * Created by idisfkj on 16/6/16.
 */
public class DynamicPlanning {

    public static int maxSubString(int[] arr, int n) {
        int start = arr[n - 1];
        int end = arr[n - 1];
        for (int k = n - 2; k >= 0; k--) {
            start = Math.max(arr[k], arr[k] + start);
            end = Math.max(start, end);
        }
        return end;
    }

    public static int knapsackProblem(int[] w, int[] v, int c) {
        int i = w.length;
        int[][] f = new int[i][c + 1];//表示第i件物品被装入且容量为j的价值。
        for (int j = 1; j <= c; j++) {
            if (j >= w[0])
                f[0][j] = v[0];
        }
        for (int n = 1; n < i; n++)
            for (int m = 1; m <= c; m++) {
                if (w[n] > m) //当前物品重量大于背包容量,则不装入背包,价值等于原来的背包价值
                    f[n][m] = f[n - 1][m];
                else {//取不装入与装入第n件背包的最大价值
                    f[n][m] = Math.max(f[n - 1][m], f[n - 1][m - w[n]] + v[n]);
                }
            }
        return f[i - 1][c];
    }

    public static void main(String[] args) {
//        int[] array = new int[]{12, -34, -45, 20, -4, 1, -15, 54, -5, 2};
//        System.out.println(maxSubString(array, array.length));

        int[] w = new int[]{2, 4, 1, 4, 3};
        int[] v = new int[]{3, 4, 5, 2, 1};
        int c = 10;
        System.out.println(knapsackProblem(w, v, c));
    }
}
