package com.idisfkj.arithmetic.ER2016;

/**
 * 最大差值
 * 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
 * 给定数组A及它的大小n，请返回最大差值。
 *
 * [10,5],2
 * 返回:0
 * Created by idisfkj on 16/9/23.
 */
public class LongestDistance {

    //贪心
    public int getDis(int[] A, int n) {
        // write code here
        int min = A[0];
        int max = 0;
        for (int k = 1; k < n; k++) {
            if (A[k] < min)
                min = A[k];
            if (A[k] - min > max)
                max = A[k] - min;
        }
        return max;
    }
}
