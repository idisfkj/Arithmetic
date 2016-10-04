package com.idisfkj.arithmetic.LeetCode;

import java.util.HashMap;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given[100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 * Your algorithm should run in O(n) complexity.
 * Created by idisfkj on 16/10/4.
 */
public class OngestConsecutiveSequence {
    public static void main(String[] args) {
        int[] num = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new OngestConsecutiveSequence().longestConsecutive(num));
    }

    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            int current = num[i];
            if (map.containsKey(current))
                continue;
            if (map.containsKey(current + 1) && map.containsKey(current - 1)) {
                int left = map.get(current - 1);
                int right = map.get(current + 1);
                int temp = left + right + 1;
                //只要更新连续系列首尾与当前的值
                map.put(current - left, temp);
                map.put(current + right, temp);
                map.put(current, temp);
            } else if (map.containsKey(current + 1)) {
                int right = map.get(current + 1);
                //只要更新连续系列尾与当前的值
                map.put(current + right, right + 1);
                map.put(current, right + 1);
            } else if (map.containsKey(current - 1)) {
                int left = map.get(current - 1);
                //只要更新连续系列首与当前的值
                map.put(current - left, left + 1);
                map.put(current, left + 1);
            } else {
                map.put(current, 1);
            }
            if (map.get(current) > max)
                max = map.get(current);
        }
        return max;
    }
}
