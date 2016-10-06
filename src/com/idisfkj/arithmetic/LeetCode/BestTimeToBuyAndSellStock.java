package com.idisfkj.arithmetic.LeetCode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * Created by idisfkj on 16/10/6.
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = new int[]{23,54,65,2,3,4,32};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
