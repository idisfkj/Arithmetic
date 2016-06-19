package com.idisfkj.arithmetic.search;

/**
 * Created by idisfkj on 16/6/14.
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int low, int height, int target) {
        if (low > height) {
            return -1;
        }
        int mid = (low + height) / 2;
        if (target < arr[mid - 1]) {
            return binarySearch(arr, low, mid - 1, target);
        } else if (target > arr[mid - 1]) {
            return binarySearch(arr, mid + 1, height, target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 21, 31, 43, 54, 60, 90};
        int res = binarySearch(array, 1, array.length, 54);
        if (res != -1)
            System.out.println("数组下标" + (res - 1) + "值为:" + array[res - 1]);
        else System.out.println("未找到!");
    }
}
