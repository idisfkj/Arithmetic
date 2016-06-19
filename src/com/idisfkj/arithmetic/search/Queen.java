package com.idisfkj.arithmetic.search;

import java.util.Scanner;

/**
 * Created by idisfkj on 16/5/23.
 */
public class Queen {
    private int n;
    private int[] x;
    private int sum;

    public static void main(String[] args) {
        Queen queen = new Queen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入皇后个数:");
        queen.n = scanner.nextInt();
        queen.x = new int[queen.n + 1];
        queen.backtrack(1);
//        queen.backtrack();
        System.out.println("总方案数:" + queen.sum);
    }

    public boolean place(int k) {
        for (int j = 1; j < k; j++) {
            if (Math.abs(k - j) == Math.abs(x[j] - x[k]) || x[j] == x[k]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归回溯
     *
     * @param k
     */
    public void backtrack(int k) {
        if (k > n) {
            sum++;
            System.out.println("方案" + sum + ":");
            for (int i = 1; i <= n; i++)
                System.out.println(x[i]);
        } else {
            for (int i = 1; i <= n; i++) {
                x[k] = i;
                if (place(k))
                    backtrack(k + 1);
            }
        }
    }

    /**
     * 非递归回溯
     */
    public void backtrack() {
        x[1] = 0;
        int k = 1;
        while (k >= 1) {
            x[k] += 1;
            while (x[k] <= n && !place(k)) {
                x[k] += 1;
            }
            if (x[k] <= n) {
                if (k == n) sum++;
                else {
                    k++;
                    x[k] = 0;
                }
            } else {
                k--;
            }
        }

    }
}
