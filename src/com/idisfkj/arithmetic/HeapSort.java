package com.idisfkj.arithmetic;

/**
 * Created by idisfkj on 16/6/15.
 */
public class HeapSort {

    /**
     * 调整成最小堆
     * @param arr 数组
     * @param top 堆顶位置
     * @param tail 堆未位置
     */
    public static void fitToMinHeap(int[] arr, int top, int tail) {
        int i = top;
        int temp = arr[i];
        int j = 2 * i + 1;//找到子节点
        while (j < tail) {
            if (j + 1 < tail && arr[j + 1] < arr[j])//找出左右子节点中的最小
                j++;

            if (arr[j] >= temp)//子节点都大于父节点则跳出
                break;

            arr[i] = arr[j];//将子节点向上移,即移到父节点
            i = j;
            j = 2 * i + 1;
        }
        arr[i] = temp;
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int j = n / 2 - 1; j >= 0; j--)//从最后一个非叶子节点开始,初始化生成数组表示的最小堆
            fitToMinHeap(arr, j, n);

        for (int i = n - 1; i > 0; i--) {//每次拿出堆的顶点值
            //把堆中的顶点与a[i]点互换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            fitToMinHeap(arr, 0, i);//交换后再对前i个节点进行最小堆化
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{32, 34, 545, 765, 876, 2, 43, 455, 44, 56, 54, 43, 4, 2, 3};
//        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
