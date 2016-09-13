package com.idisfkj.arithmetic.program;

/**
 * 求1+2+3+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * Created by idisfkj on 16/9/13.
 */
public class Sum_Solution {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    /**
     * 逻辑与短路特性
     * @param n
     * @return
     */
    public static int solution(int n) {
        int result = n;
        boolean flag = result>0 && (result += solution(n - 1))>0;
        return result;
    }
}
