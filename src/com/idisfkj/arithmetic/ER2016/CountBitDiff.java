package com.idisfkj.arithmetic.ER2016;

/**
 * Created by idisfkj on 16/9/22.
 */
public class CountBitDiff {
    public static void main(String[] args){
        System.out.println(new CountBitDiff().countBitDiff(1999,2299));
    }

    /**
     * 获得两个整形二进制表达位数不同的数量
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public int countBitDiff(int m, int n) {
        int temp = m ^ n;
        int count = 0;
        while (temp != 0) {
            count++;
            temp = temp & (temp - 1);
        }
        return count;
    }
}
