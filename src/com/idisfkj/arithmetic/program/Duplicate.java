package com.idisfkj.arithmetic.program;


/**
 * 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 * Created by idisfkj on 16/9/14.
 */
public class Duplicate {
    public static void main(String[] args) {
        int numbers[] = new int[]{2, 3, 1, 0, 2, 5, 3};
        int duplication[] = new int[1];
        System.out.println(solution(numbers, 7, duplication));
        System.out.println(duplication[0]);
    }

    public static boolean solution(int[] numbers, int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            duplication[0] = -1;
            return false;
        }
        int[] flag = new int[length];
        for (int i = 0; i < numbers.length; i++) {
            if (flag[numbers[i]] == 1) {
                duplication[0] = numbers[i];
                return true;
            }
            flag[numbers[i]] = 1;
        }
        duplication[0] = -1;
        return false;
    }
}
