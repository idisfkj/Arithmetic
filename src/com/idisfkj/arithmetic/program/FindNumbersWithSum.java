package com.idisfkj.arithmetic.program;

import java.util.*;

/**
 * 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * Created by idisfkj on 16/9/12.
 */
public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> list = solution(array,7);
        if (list.size()>0)
        System.out.println(list.get(0)+" "+list.get(1));
    }

    public static ArrayList<Integer> solution(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        int end = array.length - 1;
        int temp;
        while (start < end){
            temp = array[start] + array[end];
            if (temp < sum){
                start++;
            }else if (temp > sum){
                end--;
            }else {
                //找到的第一组就是乘积最小的
                //可以这样证明：考虑x+y=C（C是常数），x*y的大小。
                // 不妨设y>=x，y-x=d>=0，即y=x+d, 2x+d=C, x=(C-d)/2, x*y=x(x+d)=(C-d)(C+d)/4=(C^2-d^2)/4，
                // 也就是x*y是一个关于变量d的二次函数，对称轴是y轴，开口向下。d是>=0的，d越大, x*y也就越小。
                list.add(array[start]);
                list.add(array[end]);
                break;
            }
        }
        return list;
    }
}
