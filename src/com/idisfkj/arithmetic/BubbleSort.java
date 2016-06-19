package com.idisfkj.arithmetic;

/**
 * Created by idisfkj on 16/6/14.
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int temp;
        for (int n = 0; n < arr.length - 1; n++)//需要n-1次
            for (int j = 0; j < arr.length - n - 1; j++) {
                if (arr[j] > arr[j + 1]) {//交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
    }

    public static void bubbleSort2(int[] arr) {
        int temp;
        int flag = arr.length - 1;
        while (flag > 0) {
            int n = flag;
            flag = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{12, 3, 43, 5, 2, 65, 21};
//        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        bubbleSort2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
