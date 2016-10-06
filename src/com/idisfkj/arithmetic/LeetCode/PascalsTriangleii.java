package com.idisfkj.arithmetic.LeetCode;

import java.util.*;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return[1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * Created by idisfkj on 16/10/6.
 */
public class PascalsTriangleii {

    public static void main(String[] args) {
        ArrayList<Integer> res = new PascalsTriangleii().getRow2(0);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i) + " ");
        }
    }

    public ArrayList<Integer> getRow2(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] temp = new int[rowIndex];
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                //从右向左相加
                if (j == 0 || j == i)
                    temp[j] = 1;
                else
                    temp[j] = temp[j] + temp[j - 1];
            }
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            if (i == 0 || i == rowIndex)
                result.add(1);
            else
                result.add(temp[i - 1] + temp[i]);
        }
        return result;
    }

    /**
     * {@Link Triangle}
     * @param rowIndex
     * @return
     */
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] temp = new int[rowIndex];
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    temp[i] = 1;
                } else if (j == i) {
                    temp[j - 1] = 1;
                } else {
                    temp[j - 1] = temp[j - 1] + temp[j];
                }
            }
            int p = temp[i];
            int q;
            for (int k = 0; k <= i; k++) {
                q = temp[k];
                temp[k] = p;
                p = q;
            }
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            if (i == 0 || i == rowIndex)
                result.add(1);
            else
                result.add(temp[i - 1] + temp[i]);
        }
        return result;
    }
}
