package com.idisfkj.arithmetic.dp;

/**
 * Longest Increasing Subsequenece
 * Created by idisfkj on 16/8/1.
 */
public class LIS {

    public static int list(int n, int[] m) {
        int[] d = new int[n];
        int[] a = m;
        //初始化
        d[0] = 1;
        int result = d[0];
        for (int i = 1; i < n; i++) {
            d[i] = result;
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] > a[j] && d[j] >= result) {
                    d[i] = d[j] + 1;
                    result = d[i];
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = new int[]{5, 3, 4, 8, 6, 7};
        int len = list(a.length, a);
        System.out.println(len);
    }
}
