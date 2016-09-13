package com.idisfkj.arithmetic.program;

/**
 * 扑克牌顺子
 * 抽五张牌“红心A,黑桃3,小王,大王,方片5”
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4)
 * 为了方便起见,你可以认为大小王是0
 * Created by idisfkj on 16/9/13.
 */
public class isContinuous {
    public static void main(String[] args) {
        int a[] = {1,0,2,4,5};
        System.out.print(solution(a));
    }

    public static boolean solution(int[] numbers) {
        if (numbers.length != 5) return false;
        //记录最小数
        int min = 14;
        //记录最大数
        int max = -1;
        //重复判断标识
        int flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number < 0 || number > 13) return false;
            if (number == 0) continue;
            //判断是否是重复的数字(flag二进制中number位置上是否有1)
            if (((flag >> number) & 1) == 1) return false;
            //以1在二进制中的位置来记录数的大小
            flag |= (1 << number);
            if (number > max) max = number;
            if (number < min) min = number;
            if (max - min >= 5)
                return false;
        }
        return true;
    }
}