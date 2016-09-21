package com.idisfkj.arithmetic.program;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 滑动窗口的最大值
 * 如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * Created by idisfkj on 16/9/21.
 */
public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length == 0 || size > num.length || size == 0)
            return list;
        int flag = -1;
        int start = 0;
        int end = size - 1;
        int tempMax = num[start];
        while (end < num.length) {

            if (flag < start) {
                tempMax = num[start];
                for (int i = start + 1; i <= end; i++) {
                    if (num[i] > tempMax) {
                        tempMax = num[i];
                        flag = i;
                    }
                }
            } else {
                if (num[end] > tempMax) {
                    tempMax = num[end];
                    flag = end;
                }
            }
            start++;
            end++;
            list.add(tempMax);
        }
        return list;
    }

    /**
     * 使用双端队列,队列中保存数组的下标
     * 从队列尾部,插入的数据大于前面的数据则将其弹出
     * 如果队列前端第一个数大于滑动窗口的开始下标则弹出
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num.length == 0 || size == 0)
            return list;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            if (deque.isEmpty()) {
                deque.offer(i);
            } else {
                //大于则弹出前面保存的数组下标
                while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
                    deque.pollLast();
                }
                deque.offer(i);
            }
            //队列前端第一个数保存的数组下标大于滑动窗口的开始下标则弹出
            if (deque.peekFirst() < i - size + 1)
                deque.pollFirst();
            if (i >= size - 1)
                list.add(deque.peekFirst());
        }
        return list;
    }
}
