package com.idisfkj.arithmetic.program;

/**
 * 连续子数组的最大和
 * Created by idisfkj on 16/9/6.
 */
public class FindGreatestSumOfSubArray {
    public static void main(String[] args){
        int[] array = new int[]{6,-3,-2,7,-15,1,2,2};
        System.out.println(solution(array));
    }

    /**
     * {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
     * 使用dp
     * @param array
     * @return
     */
    public static int solution(int[] array){
        if (array.length==0 || array==null) {
            return 0;
        }
        int curSum=0;
        int greatestSum=array[0];
        for (int i = 0; i < array.length; i++) {
            if (curSum<=0) {
                curSum=array[i]; //重新记录
            }else {
                curSum+=array[i];
            }
            if (curSum>greatestSum) {
                greatestSum=curSum;//记录过程中的最大值
            }
        }
        return greatestSum;
    }
}
