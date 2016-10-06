package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 * *****[1],
 * ****[1,1],
 * ***[1,2,1],
 * **[1,3,3,1],
 * *[1,4,6,4,1]
 * ]
 * Created by idisfkj on 16/10/6.
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new PascalsTriangle().generate(5);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> item = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    item.add(1);
                } else {
                    item.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(item);
        }
        return result;
    }
}
