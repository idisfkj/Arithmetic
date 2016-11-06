package com.idisfkj.arithmetic.LeetCode;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * <p>
 * Above is a histogram where width of each bar is 1, given height =[2,1,5,6,2,3].
 * <p>
 * <p>
 * The largest rectangle is shown in the shaded area, which has area =10unit.
 * <p>
 * For example,
 * Given height =[2,1,5,6,2,3],
 * return10.
 * <p>
 * Created by idisfkj on 16/11/6.
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] height = new int[]{2,1,5,6,2};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(height));
    }


    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int i = 0;

        while (i < height.length) {
            //push index to stack when the current height is larger than the previous one
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                //calculate max value when the current height is less than the previous one
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }

        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }
}
