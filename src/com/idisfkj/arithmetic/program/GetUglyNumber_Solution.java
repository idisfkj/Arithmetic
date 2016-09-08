package com.idisfkj.arithmetic.program;

/**
 * 丑数
 * Created by idisfkj on 16/9/7.
 */
public class GetUglyNumber_Solution {
    public static void main(String[] args){
        System.out.println(solution1(11));
    }


    /**
     * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * @param index
     * @return
     */
    public static int solution1(int index){
        if (index<=0){
            return 0;
        }
        int i1=0;
        int i2=0;
        int i3=0;
        int[] result = new int[index];
        result[0] = 1;
        for (int i =1;i<index;i++){
            result[i] = Math.min(result[i1]*2,Math.min(result[i2]*3,result[i3]*5));
            if(result[i] == result[i1]*2) i1++;
            if (result[i] == result[i2]*3) i2++;
            if (result[i] == result[i3]*5) i3++;
        }
        return result[index-1];
    }


    public static int solution(int index){
        int result = 0;
        int temp;
        while (index > 0){
            result++;
            temp = result;
            while (temp > 1){
                if(temp%2 == 0){
                    temp = temp /2;
                }else if (temp%3 == 0){
                    temp = temp / 3;
                }else if(temp%5 == 0){
                    temp = temp / 5;
                }else {
                    temp = -1;
                }
            }
            if(temp == 1)
                index--;
        }
        return result;
    }
}
