package com.idisfkj.arithmetic.LeetCode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * <p>
 * Created by idisfkj on 16/10/6.
 */
public class BestTimeToBuyAndSellStockiii {
    public static void main(String[] args) {
        int[] prices = new int[]{23, 54, 65, 2, 3, 4, 32};
        System.out.println(new BestTimeToBuyAndSellStockiii().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, maxProfit(prices, 0, i) + maxProfit(prices, i, prices.length - 1));
        }
        return max;
    }

    public int maxProfit(int[] prices, int start, int end) {
        if (start == end)
            return 0;
        int max = 0;
        int min = prices[start];
        for (int i = start + 1; i < end + 1; i++) {
            if (prices[i] < min)
                min = prices[i];
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
