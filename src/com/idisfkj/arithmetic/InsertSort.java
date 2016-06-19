package com.idisfkj.arithmetic;

/**
 * Created by idisfkj on 16/6/14.
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {//交换
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {//只要比较不小于的话就直接跳出
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{23, 43, 587, 24, 5, 23, 21};
//        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
