package com.idisfkj.arithmetic;

/**
 * Created by idisfkj on 16/6/14.
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        int temp;
        //增量值
        int d = arr.length / 2;
        while (true) {
            for (int i = 0; i < d; i++) {//分成若干组进行排序
                for (int j = i; j + d < arr.length; j += d) {
                    for (int k = j + d; k - d >= 0; k -= d) {//使用直接插入排序
                        if (arr[k] < arr[k - d]) {
                            temp = arr[k];
                            arr[k] = arr[k - d];
                            arr[k - d] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (d == 1) break;
            d = d / 2;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{23, 4, 6, 34, 35, 47, 546, 32, 6};
//        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        shellSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
