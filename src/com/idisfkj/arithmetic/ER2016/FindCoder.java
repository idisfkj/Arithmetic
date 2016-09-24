package com.idisfkj.arithmetic.ER2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 寻找Coder
 * 请设计一个高效算法，再给定的字符串数组中，找到包含"Coder"的字符串(不区分大小写)，
 * 并将其作为一个新的数组返回。结果字符串的顺序按照"Coder"出现的次数递减排列，
 * 若两个串中"Coder"出现的次数相同，则保持他们在原数组中的位置关系。
 *
 * ["i am a coder","Coder Coder","Code"],3
 * 返回：["Coder Coder","i am a coder"]
 * Created by idisfkj on 16/9/23.
 */
public class FindCoder {
    public class CoderSave {
        private int count;
        private int position;

        public CoderSave(int count, int position) {
            this.count = count;
            this.position = position;
        }
    }

    public String[] findCoder(String[] A, int n) {
        // write code here
        ArrayList<CoderSave> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (A[i].toLowerCase().contains("coder")) {
                int pre = A[i].length();
                int cur = A[i].toLowerCase().replace("coder", "").length();
                int sub = (pre - cur) / 5;
                list.add(new CoderSave(sub, i));
            }
        }
        Collections.sort(list, new Comparator<CoderSave>() {
            @Override
            public int compare(CoderSave o1, CoderSave o2) {
                if (o1.count != o2.count)
                    return o2.count - o1.count;
                else
                    return o1.position - o2.position;
            }
        });

        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = A[list.get(i).position];
        }
        return result;
    }
}
