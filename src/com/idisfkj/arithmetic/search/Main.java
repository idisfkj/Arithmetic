package com.idisfkj.arithmetic.search;

import java.util.Scanner;

/**
 * Created by idisfkj on 16/5/17.
 */
public class Main {
    /**
     * 集装箱数量
     */
    private int boxNumber;
    /**
     * 临时装载状态
     */
    private int[] result;
    /**
     * 最好的装载状态
     */
    private int[] bestResult;
    /**
     * 各个集装箱重量
     */
    private int[] weight;
    /**
     * 装载容量
     */
    private int c;
    /**
     * 当前装载重量
     */
    private int currentC;
    /**
     * 最好的装载重量
     */
    private int bestC;
    /**
     * 剩余重量
     */
    private int remainWeight;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("总的装载容量:");
        main.c = scanner.nextInt();

        System.out.println("集装箱数量:");
        main.boxNumber = scanner.nextInt();

        System.out.println("各个集装箱重量:");
        main.weight = new int[main.boxNumber + 1];
        for (int i = 1; i <= main.boxNumber; i++) {
            main.weight[i] = scanner.nextInt();
        }

        main.result = new int[main.boxNumber + 1];
        main.bestResult = new int[main.boxNumber + 1];
        main.currentC = 0;
        main.bestC = 0;
        main.remainWeight = 0;

        //初始化remainWeight
        for (int i = 1; i <= main.boxNumber; i++) {
            main.remainWeight += main.weight[i];
        }
        main.backtrack(1);

        System.out.println("各个集装箱的装载状态:");
        for (int i = 1; i <= main.boxNumber; i++) {
            System.out.println(main.bestResult[i]);
        }

        System.out.println("最佳装载重量:" + main.bestC);
    }

    public void backtrack(int i) {
        //搜索第i层节点
        if (i > boxNumber) {//到达叶子节点
            if (currentC > bestC) {
                for (int j = 1; j <= boxNumber; j++)
                    bestResult[j] = result[j];
                bestC = currentC;
            }
            return;
        }

        //搜索子数
        remainWeight -= weight[i];
        if (currentC + weight[i] <= c) {//搜索左子数
            result[i] = 1;
            currentC += weight[i];
            backtrack(i + 1);
            currentC -= weight[i];
        }

        if (currentC + remainWeight > bestC) {//搜索右子数
            result[i] = 0;
            backtrack(i + 1);
        }
        remainWeight += weight[i];
    }
}
