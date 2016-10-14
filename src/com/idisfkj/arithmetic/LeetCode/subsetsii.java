package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * iven a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If S =[1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * Created by idisfkj on 16/10/14.
 */
public class Subsetsii {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] num = new int[]{4, 1, 0};
        ArrayList<ArrayList<Integer>> res = new Subsetsii().subsetsWithDup2(num);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j));
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num) {
        if (num == null || num.length == 0)
            return result;
        Set<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            if (i == 0) {
                ArrayList<Integer> empty = new ArrayList<>();
                result.add(empty);//空串
                ArrayList<Integer> item = new ArrayList<>();
                item.add(num[i]);
                result.add(item);
                set.add(item);
            } else {
                ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
                //从前的结果集合中再进行插入(dp[i] = dp[i-1] + num[i] )
                for (int j = 0; j < result.size(); j++) {
                    ArrayList<Integer> older = new ArrayList<>(result.get(j));
                    older.add(num[i]);
                    Collections.sort(older);
                    if (!set.contains(older)) {
                        temp.add(older);
                        set.add(older);
                    }
                }
                result.addAll(temp);
            }
        }
        return result;
    }


    //复杂度过高
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        //1 2 3 4 5
        if (num == null || num.length == 0)
            return result;
        int count = num.length;
        int[] flag = new int[num.length];
        while (count >= 0) {
            ArrayList<Integer> item = new ArrayList<>();
            subsetsWithDup(num, count, flag, item);
            count--;
        }
        return result;
    }

    public void subsetsWithDup(int[] num, int count, int[] flag, ArrayList<Integer> list) {
        if (list.size() == count) {
            ArrayList<Integer> temp = (ArrayList<Integer>) list.clone();
            Collections.sort(temp);
            if (!result.contains(temp)) {
                result.add(temp);
            }
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (flag[i] != 1) {
                list.add(num[i]);
                flag[i] = 1;
                subsetsWithDup(num, count, flag, list);
                flag[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
