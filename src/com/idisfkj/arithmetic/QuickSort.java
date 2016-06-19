package com.idisfkj.arithmetic;

/**
 * Created by idisfkj on 16/6/15.
 */
public class QuickSort {

    /**
     * 排序
     *
     * @param arr    数组
     * @param low    最低标志位
     * @param height 最高标志位
     * @return 一轮排序完后关键数所在的位置
     */
    public static int sort(int[] arr, int low, int height) {
        int i = low;
        int j = height;
        int k = arr[low];//记录开始的关键数
        while (i < j) {
            while (i < j && arr[j] >= k) //先从右向左找到第一个小于k的位置
                j--;
            if (i < j) {
                arr[i] = arr[j];//将找到的数替换到i位置
                i++;
            }

            while (i < j && arr[i] <= k) //再从左向右找到第一个大于k的位置
                i++;
            if (i < j) {
                arr[j] = arr[i];//将找到的数替换到j位置
                j--;
            }
        }
        arr[i] = k;//当i == j 时,最后将最初的关键数替代到i位置
        return i;
    }

    /**
     * 分治递归
     *
     * @param arr    数组
     * @param low    最低标志位
     * @param height 最高标志位
     */
    public static void quickSort(int[] arr, int low, int height) {
        if (low < height) {
            int mid = sort(arr, low, height);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, height);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{23, 43, 23, 57, 78, 5, 6, 235, 23, 54, 3};
//        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
