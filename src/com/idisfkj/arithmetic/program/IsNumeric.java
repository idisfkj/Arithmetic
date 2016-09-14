package com.idisfkj.arithmetic.program;

/**
 * 表示数值的字符串
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * Created by idisfkj on 16/9/14.
 */
public class IsNumeric {
    public static void main(String[] args) {
        char[] str = new char[]{'1', 'a', '3', '.', '1'};
        System.out.println(solution1(str));
    }

    public static boolean solution1(char[] str) {
        if (str == null || str.length == 0)
            return false;
        return solution(str, -1, 0);
    }

    /**
     * @param str 字符串
     * @param flag -1 代表未定 0 代表纯数字 1代表有e 2 代表有小数
     * @param index 遍历位置
     * @return
     */
    public static boolean solution(char[] str, int flag, int index) {
        //遍历完结束
        if (index == str.length)
            return true;

        //还未判断是何种类型的数字
        if (flag == -1) {
            if (str[index] == '+' || str[index] == '-')
                //如果此时的+或-处在首位
                if (index == 0)
                    return solution(str, -1, index + 1);
                else
                    return false;

            //为e类型数字
            if (str[index] == 'e' || str[index] == 'E')
                //e类型数字后面必须有字符
                if (index + 1 < str.length)
                    return solution(str, 1, index + 1);
                else
                    return false;

            //为.类型数字
            if (str[index] == '.')
                return solution(str, 2, index + 1);

            if (str[index] >= '0' && str[index] <= '9')
                return solution(str, -1, index + 1);
            else
                return false;
        }

        //只能为数字
        if (flag == 0) {
            if (str[index] >= '0' && str[index] <= '9') {
                return solution(str, 0, index + 1);
            }
            return false;
        }

        //前面已经有e
        if (flag == 1) {
            if (str[index] == '+' || str[index] == '-') {
                //下一个只能为数字
                return solution(str, 0, index + 1);
            }
            //不为数字
            if (str[index] <= '0' || str[index] > '9')
                return false;
            else
                return solution(str, 0, index + 1);
        }

        //前面有.
        if (flag == 2) {
            if (str[index] == '.')
                return false;
            else if (str[index] == 'e' || str[index] == 'E')
                //前面必须有数字
                if (str[index - 1] >= '0' && str[index - 1] <= '9')
                    return solution(str, 1, index + 1);
                else
                    return false;
            else
                return solution(str, 2, index + 1);
        }
        return true;
    }
}
