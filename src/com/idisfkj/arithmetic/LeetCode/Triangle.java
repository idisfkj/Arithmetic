package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 * ****[2],
 * ***[3,4],
 * **[6,5,7],
 * *[4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * Created by idisfkj on 16/10/6.
 */
public class Triangle {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        int[][] temp = new int[][]{{-1}, {-2, -3}};
        for (int i = 0; i < temp.length; i++) {
            ArrayList<Integer> item = new ArrayList<>();
            for (int j = 0; j < temp[i].length; j++) {
                item.add(temp[i][j]);
            }
            triangle.add(item);
        }
        System.out.println(new Triangle().minimumTotal(triangle));
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        //最后一层大小的辅助空间
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        int min = dp[0];
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //每层相应位置存储的dp值,所在位置向左移动一位(位置0存储在i位置上)
                //因为每次都要取当前数字肩上的两个值进行比较,防止上一层的值被该层前面的值所覆盖
                if (j == 0) {
                    dp[i] = dp[j] + triangle.get(i).get(j);
                    min = dp[i];
                } else if (j == triangle.get(i).size() - 1) {
                    dp[j - 1] = dp[j - 1] + triangle.get(i).get(j);
                } else {
                    dp[j - 1] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                }

                if (j != 0 && dp[j - 1] < min)
                    min = dp[j - 1];
            }
            int p = dp[i];
            int q;
            //恢复原来的位置
            for (int k = 0; k <= i; k++) {
                q = dp[k];
                dp[k] = p;
                p = q;
            }
        }
        return min;
    }
}
