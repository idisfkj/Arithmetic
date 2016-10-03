package com.idisfkj.arithmetic.LeetCode;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * Created by idisfkj on 16/10/3.
 */
public class Candy {

    public static void main(String[] args) {
        int[] ratings = new int[]{1, 2, 2};
        System.out.println(new Candy().candy(ratings));
    }

    public int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        //先从左向右
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        //从右向左
        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1] && dp[j] <= dp[j + 1]) {
                dp[j] = dp[j + 1] + 1;
            }
        }
        int result = 0;
        for (int k = 0; k < dp.length; k++) {
            result += dp[k];
        }
        return result + dp.length;
    }
}
