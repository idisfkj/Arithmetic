package com.idisfkj.arithmetic.program;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 最小的K个数
 * Created by idisfkj on 16/9/6.
 */
public class GetLeastNumbers_Solution {
    public static void main(String[] args) {
        int[] array = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = solution(array,4);
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    /**
     * 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * 使用堆排序时间复杂度为O(nlogk)
     * @param array
     * @param k
     * @return
     */
    public static ArrayList<Integer> solution(int[] array, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length == 0 || array.length < k) {
            return result;
        }
        int len = array.length;
        //初始化构造最大堆
        for (int j = k/2-1; j >= 0; j--){
            fitToMaxHeap(array,j,k);
        }

        for (int n = k; n < len;n++){
            //与堆顶交换
            if(array[n] < array[0]) {
                int temp = array[n];
                array[n] = array[0];
                array[0] = temp;
                //调整成最大堆
                fitToMaxHeap(array, 0, k);
            }
        }
        //数组中前k个数就是最小的k个数
        for (int m = 0; m <k;m++){
            result.add(array[m]);
        }
        return result;
    }

    /**
     * 构造最大堆
     * @param array
     * @param top
     * @param tail
     */
    public static void fitToMaxHeap(int[] array, int top, int tail) {
        int i = top;
        //获取第一个子节点
        int j = 2 * i + 1;
        int temp = array[i];
        while (j < tail) {
            if (j + 1 < tail && array[j + 1] > array[j])
                j++;
            if (array[j] > temp) {
                array[i] =array[j];
            }else {
                break;
            }
            i = j;
            j = 2 * i + 1;
        }
        array[i] = temp;
    }
}
