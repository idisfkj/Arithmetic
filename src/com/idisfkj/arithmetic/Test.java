package com.idisfkj.arithmetic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by idisfkj on 16/8/5.
 */
public class Test {

    //直接选择排序
    public static void selectSort(int[] arr) {
        int temp;
        int flag;
        for (int i = 0; i < arr.length; i++) {
            flag = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[flag]) {
                    flag = j;
                }
            }
            if (flag != i) {
                temp = arr[i];
                arr[i] = arr[flag];
                arr[flag] = temp;
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //优化
    public static void bubbleSort2(int[] arr) {
        int flag = arr.length - 1;
        int temp;
        while (flag > 0) {
            int n = flag;
            flag = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i + 1] < arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = i;
                }
            }
        }
    }

    //直接插入排序
    public static void insertSort(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    //归并排序
    public static void merge(int[] arr, int low, int mid, int height) {
        int[] temp = new int[height - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= height) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= height) {
            temp[k++] = arr[j++];
        }

        for (int m = 0; m < temp.length; m++) {
            arr[low + m] = temp[m];
        }
    }

    public static void mergeSort(int[] arr, int low, int height) {
        if (low < height) {
            int mid = (low + height) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, height);
            merge(arr, low, mid, height);
        }
    }

    //快速排序
    public static int sort(int[] arr, int low, int height) {
        int result;
        int flag = arr[low];
        int i = low;
        int j = height;
        while (i < j) {
            while (arr[j] > flag && j > i) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (arr[i] <= flag && i < j) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = flag;
        result = i;
        return result;
    }

    public static void quickSort(int[] arr, int low, int height) {
        if (low < height) {
            int mid = sort(arr, low, height);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, height);
        }

    }

    //希尔排序
    public static void shellSort(int[] arr) {
        int d = arr.length / 2;
        int temp;
        while (true) {
            for (int i = 0; i < d; i++) {
                for (int j = i + d; j < arr.length; j += d) {
                    for (int k = j; k - d >= 0; k -= d) {
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

    //堆排序
    public static void fitMaxHeap(int[] arr, int top, int tail) {
        int i = top;
        int temp = arr[i];
        int j = 2 * top + 1;
        while (j < tail) {
            if (j + 1 < tail && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[j] < temp) break;
            arr[i] = arr[j];
            i = j;
            j = i * 2 + 1;
        }
        arr[i] = temp;
    }

    public static void heapSort(int[] arr) {
        int temp;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            fitMaxHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            fitMaxHeap(arr, 0, j);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 334, 5, 213, 45, 7, 0, 34};
//        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
//        selectSort(array);
//        bubbleSort(array);
//        bubbleSort2(array);
//        insertSort(array);
//        mergeSort(array, 0, array.length - 1);
//        quickSort(array, 0, array.length - 1);
//        shellSort(array);
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        //ArrayList的动态代理
//        final List<String> list = new ArrayList<>();
//        List<String> proxInstance = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return method.invoke(list,args);
//            }
//        });
//
//        proxInstance.add("你好!");
//        System.out.println(list);
    }
}
