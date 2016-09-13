package com.idisfkj.arithmetic.program;

/**
 * 把字符串转换成整数
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * Created by idisfkj on 16/9/13.
 */
public class StrToInt {
    public static void main(String[] args) {
        System.out.println(solution("-12"));
    }

    public static int solution(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int result = 0;
        int i = 0;
        boolean flag = false;
        char first = str.charAt(i);
        if (first < '0') {
            if (first == '-') {
                flag = true;
            } else if (first != '+') {
                return 0;
            }
            i++;
        }
        while (i < str.length()) {
            //转换为数字
            int digit = Character.digit(str.charAt(i++), 10);
//            int digit = -1;
//            if (str.charAt(i)>= '0' && str.charAt(i) <= '9')
//                digit = str.charAt(i++)-'0';
            if (digit < 0)
                return 0;
            result *= 10;
            result += digit;
        }
        return flag ? -result : result;
    }
}
