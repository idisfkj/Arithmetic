package com.idisfkj.arithmetic.program;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * Created by idisfkj on 16/9/7.
 */
public class NumberOf1Between1AndN_Solution {
    public static void main(String[] args){
        int result =solution(13);
        System.out.println(result);
    }

    public static int solution(int n){
        int count = 0;
        for (int i = 1; i <=n;i++){
            String str = String.valueOf(i);
            for (int j = 0; j < str.length();j++){
                if(str.charAt(j) == '1')
                    count++;
            }
        }
        return count;
    }
}
