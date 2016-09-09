package com.idisfkj.arithmetic.program;

/**
 * 数组中的逆序对
 * Created by idisfkj on 16/9/8.
 */
public class InversePairs {

    public static int count = 0;
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(solution(array));
    }

    public static int solution(int[] array) {
        mergeSort(array,0,array.length-1);
        return count%1000000007;
    }

    /**
     * 归并
     * @param array
     * @param low
     * @param mid
     * @param height
     */
    public static void merge(int[] array, int low, int mid, int height) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[height - low + 1];
        while (i <= mid && j <= height) {
            if (array[i]<=array[j]){
                temp[k++] = array[i++];
            }else {
                //后面的都大于array[j]
                count+=mid-i+1;
                temp[k++] = array[j++];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
        }
        while (i<=mid){
            temp[k++] = array[i++];
        }
        while (j<=height){
            temp[k++] = array[j++];
        }
        for (int n = 0; n <temp.length;n++){
            array[low+n] = temp[n];
        }
    }

    public static void mergeSort(int[] array,int low,int height){
        if (low<height){
            int mid = (low+height) / 2;
            mergeSort(array,low,mid);
            mergeSort(array,mid+1,height);
            merge(array,low,mid,height);
        }
    }
}
