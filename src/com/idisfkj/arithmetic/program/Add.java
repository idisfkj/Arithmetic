package com.idisfkj.arithmetic.program;

/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * Created by idisfkj on 16/9/13.
 */
public class Add {
    public static void main(String[] args) {
        System.out.println(solution(3,9));
    }

    public static int solution(int num1, int num2) {
        while (num2 != 0) {
            //得到二进制数相加不需要进位位;
            int temp = num1 ^ num2;
            //得到二进制数相加需要进位位(最终没有进位位)
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
