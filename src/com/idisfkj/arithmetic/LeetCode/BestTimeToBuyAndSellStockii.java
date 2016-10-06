package com.idisfkj.arithmetic.LeetCode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * <p>
 * Created by idisfkj on 16/10/6.
 */
public class BestTimeToBuyAndSellStockii {

    public static void main(String[] args) {
        int[] prices = new int[]{23, 54, 65, 2, 3, 4, 32};
        System.out.println(new BestTimeToBuyAndSellStockii().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int min = prices[0];
        int max = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                result += max - min;
                min = max = prices[i];
            } else {
                max = prices[i];
            }
        }
        if (max != min)
            result += max - min;
        return result;
    }
}
