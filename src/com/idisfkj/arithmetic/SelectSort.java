package com.idisfkj.arithmetic;

/**
 * Created by idisfkj on 16/6/14.
 */
public class SelectSort {

    public static void selectSort(int[] arr) {
        int temp;
        int mid;
        for (int i = 0; i < arr.length - 1; i++) {
            mid = i;//关键数
            for (int j = mid + 1; j < arr.length; j++) {
                if (arr[mid] > arr[j])//找到最小值
                    mid = j;
            }
            if (mid != i) {//不等于关键数则交换
                temp = arr[mid];
                arr[mid] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{43,12,56,87,2,421,532,132,45,45};
        selectSort(array);
        for (int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
