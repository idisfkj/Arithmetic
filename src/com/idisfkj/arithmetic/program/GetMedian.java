package com.idisfkj.arithmetic.program;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 数据流中的中位数
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * Created by idisfkj on 16/9/21.
 */
public class GetMedian {

    private ArrayList<Integer> list = new ArrayList<>();

    public void insert(Integer num) {
        list.add(num);
        Collections.sort(list);
    }

    public Double getMedian() {
        if (list.size() % 2 != 0) {
            return Double.valueOf(list.get(list.size() / 2));
        } else {
            return (Double.valueOf(list.get(list.size() / 2) + Double.valueOf(list.get(list.size() / 2 - 1))) / 2);
        }
    }
}
