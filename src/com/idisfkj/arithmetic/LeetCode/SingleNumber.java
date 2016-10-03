package com.idisfkj.arithmetic.LeetCode;

/**
 * Created by idisfkj on 16/10/3.
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] A = new int[]{2, 3, 3, 41, 35, 41, 35};
        System.out.println(new SingleNumber().singleNumber(A));
    }

    //2 3 4 3 2
    // 10  11
    //   01 100
    //    101  11
    //      110 10
    //      100
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
}
