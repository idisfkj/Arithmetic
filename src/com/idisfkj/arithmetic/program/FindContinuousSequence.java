package com.idisfkj.arithmetic.program;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 * (至少包括两个数)。如100的序列:18,19,20,21,22。
 * Created by idisfkj on 16/9/12.
 */
public class FindContinuousSequence {
    public static int mSum;
    public static int temp;
    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        solution(100);
        for (int i = 0; i < result.size(); i++){
            for (int j = 0; j < result.get(i).size();j++){
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> solution(int sum) {
//        mSum = sum;
//        temp = mSum;
//        ArrayList<Integer> item = new ArrayList<>();
//        search(1,item);

        /**
         * 两个标记start与end,开始时stat=1,end=2;
         * 如果从start到end的和大于sum,则start++
         * 否则end++;
         * 直到start == (1+sum)>>1 且 end < sum 为止
         */
        int mid = (sum+1)>>1;
        int start = 1;
        int end = start+1;
        int temp = start+end;
        while (start < mid && end <sum){
            while (temp > sum){
                temp-=start;
                start++;
            }
            if (temp == sum){
                ArrayList<Integer> item = new ArrayList<>();
                for (int i = start; i <= end; i++){
                    item.add(i);
                }
                result.add(item);
            }
            end++;
            temp+=end;
        }
        return result;
    }


    /**
     * 常见思路
     * @param sum
     * @param item
     */
    public static void search(int sum,ArrayList<Integer> item){
        item.add(sum);
        mSum-=sum;
        if (mSum > 0){
            search(sum+1,item);
        }else if (mSum == 0 && item.size()>1){
            result.add(item);
        }
        mSum+=sum;
        //进行下一组寻找
        if (mSum == temp && sum < temp - 1) {
            ArrayList<Integer> nextItem = new ArrayList<>();
            search(sum + 1,nextItem);
        }
    }
}
