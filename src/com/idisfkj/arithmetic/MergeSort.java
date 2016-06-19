package com.idisfkj.arithmetic;

/**
 * Created by idisfkj on 16/6/14.
 */
public class MergeSort {

    /**
     * 合并
     *
     * @param arr    数组
     * @param low    最低标志位
     * @param mid    划分标志位
     * @param height 最高标志位
     */
    public static void merge(int[] arr, int low, int mid, int height) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[height - low + 1];
        while (i <= mid && j <= height) {
            if (arr[i] <= arr[j]) {//左边加入
                temp[k++] = arr[i++];
            } else {//右边加入
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {//左边剩余全部加入
            temp[k++] = arr[i++];
        }

        while (j <= height) {//右边剩余全部加入
            temp[k++] = arr[j++];
        }

        for (int m = 0; m < temp.length; m++) {//辅助数组还原到原数组
            arr[low + m] = temp[m];
        }
    }

    /**
     * 归并排序
     *
     * @param arr    数组
     * @param low    最低位标志
     * @param height 最高位标志
     */
    public static void mergeSort(int[] arr, int low, int height) {
        if (low < height) {
            int mid = (low + height) / 2;
            mergeSort(arr, low, mid);//左划分
            mergeSort(arr, mid + 1, height);//右划分
            merge(arr, low, mid, height);//左右归并
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{21, 34, 5, 6, 769, 235, 34, 12};
//        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
