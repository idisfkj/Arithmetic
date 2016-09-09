package com.idisfkj.arithmetic.program;

/**
 * 数字在排序数组中出现的次数
 *
 * 统计一个数字在排序数组中出现的次数。
 * Created by idisfkj on 16/9/8.
 */
public class GetNumberOfK {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(solution(array, 3));
    }

    /**
     * 二分查找
     *
     * @param array
     * @param k
     * @return
     */
    public static int solution(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int low = 0;
        int height = array.length - 1;
        int mid;
        int flag = -1;
        //非递归二分查找,直到找到第一个k为止
        while (low <= height) {
            mid = (low + height) >> 1;
            if (array[mid] < k) {
                low = mid + 1;
            } else if (array[mid] > k) {
                height = mid - 1;
            } else {
                flag = mid;
                break;
            }
        }

        if (flag == -1)
            return 0;
        low = flag - 1;
        height = flag + 1;
        //从找到的第一的k的位置向前与向后查找,找到真正第一个k,与最后一个k所在数组的下标
        while (low >= 0 && array[low] == k) {
            low--;
        }
        while (height <= array.length - 1 && array[height] == k) {
            height++;
        }
        //因为数组是有序
        return height - low - 1;
    }
}
