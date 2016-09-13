package com.idisfkj.arithmetic.program;

import java.util.LinkedList;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 * Created by idisfkj on 16/9/13.
 */
public class LastRemaining_Solution {
    public static void main(String[] args) {
        System.out.println(solution(4,2));
    }

    /**
     * 循环队列
     * @param n
     * @param m
     * @return
     */
    public static int solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int current = 0;
        int len = n;
        while (len > 1) {
            current = (current + m - 1) % len;
            list.remove(current);
            len--;
        }
        return list.remove();
    }

    /**
     * 约瑟夫递归
     * @param n
     * @param m
     * @return
     */
    public static int solution1(int n,int m){
        if (n<1||m<1)
            return -1;
        if (n==1)
            return 0;
        return (solution1(n-1,m)+m)%n;
    }
}
