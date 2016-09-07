package com.idisfkj.arithmetic.program;

/**
 * 数组中出现次数超过一半的数字
 * Created by idisfkj on 16/9/6.
 */
public class MoreThanHalfNum_Solution {
    public static void main(String[] args){
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(solution(array));
    }

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
     * 如果不存在则输出0。
     *
     * 思想:阵地攻防
     * 第一个数字作为第一个士兵，守阵地；count = 1；
     * 遇到相同元素，count++;
     * 遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是最后一个。
     * 再加一次循环，记录这个士兵的个数看是否大于数组一半即可。
     * @return
     */
    public static int solution(int[] array){
        if(array.length == 0)
            return 0;
        int count = 1;
        int flag = array[0];
        //阵地攻防
        for(int i = 1;i < array.length; i++){
            if(array[i] == flag)
                count++;
            else
                count--;
            if(count == 0){
                flag = array[i];
                count = 1;
            }
        }

        if(count > 1){
            return flag;
        }

        //验证(可能为最后一个)
        count = 0;
        for (int j = 0; j < array.length; j++){
            if(array[j] == flag){
                count++;
            }
        }
        if(count > array.length/2){
            return flag;
        }else {
            return 0;
        }
    }
}
