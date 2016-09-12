package com.idisfkj.arithmetic.program;

/**
 * 左旋转字符串
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 * Created by idisfkj on 16/9/12.
 */
public class LeftRotateString {
    public static void main(String[] args) {
        String str = ",";
        System.out.println(solution(str,6));
    }

    public static String solution(String str, int n) {
        String result;
        int len = str.length();
        int sub = 0;
        //java (javac 1.7)要判断%后面的数是否为0,否则会报
        // java.lang.ArithmeticException: / by zero
        if (len!=0)
        sub = n % len;

        if (sub == 0) {
            result = str;
        } else {
            result = str.replaceFirst(str.substring(0, sub), "") + str.substring(0, sub);
        }
        return result;
    }
}
