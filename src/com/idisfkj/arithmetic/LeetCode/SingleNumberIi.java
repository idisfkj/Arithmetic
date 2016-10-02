package com.idisfkj.arithmetic.LeetCode;

import java.util.HashMap;

/**
 * Created by idisfkj on 16/10/2.
 */
public class SingleNumberIi {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 2, 3, 4, 1, 2, 3, 1};
        System.out.println(new SingleNumberIi().singleNumber1(A));
    }

    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) != null) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1)
                return key;
        }
        return 0;
    }

    public int singleNumber1(int[] A) {
        int ones = 0;//记录只出现过1次的bits
        int twos = 0;//记录只出现过2次的bits
        int threes;
        for (int i = 0; i < A.length; i++) {
            int t = A[i];
            twos |= ones & t;//要在更新ones前面更新twos
            ones ^= t;
            threes = ones & twos;//ones和twos中都为1即出现了3次
            ones &= ~threes;//抹去出现了3次的bits
            twos &= ~threes;
        }
        return ones;
    }
}
