package com.idisfkj.arithmetic.ER2016;

/**
 * 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。
 * 若两次交易机会都放弃，收益为0
 * Created by idisfkj on 16/9/22.
 */
public class CalculateMax {

    public static void main(String[] args) {
        int[] prices = new int[]{5, 15, 56, 26, 62, 65, 57, 69};
        System.out.println(new CalculateMax().calculateMax(prices));
    }

    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    //3,8,5,1,7,8
    //12
    //5,15,56,26,62,65,57,69
    //94
    public int calculateMax(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            //划分成前后两部分进行求解
            int temp = getMax(prices, 0, i) + getMax(prices, i, prices.length - 1);
            if (temp > sum)
                sum = temp;
        }
        return sum;
    }

    public int getMax(int[] prices, int n, int m) {
        int result = 0;
        int min = prices[n];
        for (int i = n; i <= m; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > result) {
                result = prices[i] - min;
            }
        }
        return result;
    }
}
