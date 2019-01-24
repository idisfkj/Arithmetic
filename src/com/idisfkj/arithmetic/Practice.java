package com.idisfkj.arithmetic;

/**
 * Created by idisfkj on 16/11/7.
 */
public class Practice {

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] array) {
        int flag = array.length - 1;
        int k;
        while (flag > 0) {
            k = flag;
            flag = 0;
            for (int i = 0; i < k; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = i;
                }
            }
        }
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= end) {
            temp[k++] = array[j++];
        }

        for (int m = 0; m < temp.length; m++) {
            array[start + m] = temp[m];
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = sort(array, start, end);
            quickSort(array, start, mid - 1);
            quickSort(array, mid + 1, end);
        }
    }

    public static int sort(int[] array, int start, int end) {
        int temp = array[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && array[j] > temp) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }

            while (i < j && array[i] <= temp) {
                i++;
            }

            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = temp;
        return i;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 23, 6, 7, 33, 3, 44, 55};
//        bubbleSort(array);
//        bubbleSort2(array);
//        mergeSort(array, 0, array.length - 1);
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
