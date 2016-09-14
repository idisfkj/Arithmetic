package com.idisfkj.arithmetic.program;

/**
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * Created by idisfkj on 16/9/14.
 */
public class Multiply {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[] B = solution1(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }

    public static int[] solution1(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        //前段部分(从前往后)
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        //后半部分(从后往前)
        int temp = 1;
        for (int j = A.length - 2; j >= 0; j--) {
            temp = temp * A[j + 1];
            B[j] *= temp;
        }
        return B;
    }


    /**
     * 一般思路
     *
     * @param A
     * @return
     */
    public static int[] solution(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int start = 0;
            int end = A.length - 1;
            int left = i - 1;
            int right = i + 1;
            int leftResult = 1;
            int rightResult = 1;
            while (left >= start) {
                leftResult *= A[left--];
            }
            while (right <= end) {
                rightResult *= A[right++];
            }
            B[i] = leftResult * rightResult;
        }
        return B;
    }
}
