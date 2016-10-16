package com.idisfkj.arithmetic.LeetCode;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 * <p>
 * Created by idisfkj on 16/10/16.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] temp = new int[m + n];
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = B[j++];
            }
        }
        while (i < m)
            temp[k++] = A[i++];
        while (j < n)
            temp[k++] = B[j++];
        for (int a = 0; a < temp.length; a++)
            A[a] = temp[a];
    }
}
