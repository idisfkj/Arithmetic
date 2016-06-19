package com.idisfkj.arithmetic.search;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by idisfkj on 16/5/24.
 */
public class RandomQueen {
    private int[] x;
    private int n;
    private int[] y;

    public static void main(String[] args) {
        RandomQueen randomQueen = new RandomQueen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入皇后数:");
        randomQueen.n = scanner.nextInt();
        randomQueen.x = new int[randomQueen.n + 1];
        randomQueen.y = new int[randomQueen.n + 1];
        while (!randomQueen.queenLV()) ;
        System.out.println("结果为:");
        for (int i = 1; i <= randomQueen.n; i++) {
            System.out.println(randomQueen.x[i]);
        }
    }

    public boolean place(int k) {
        for (int i = 1; i < k; i++) {
            if ((Math.abs(k - i) == Math.abs(x[i] - x[k])) || (x[i] == x[k]))
                return false;
        }
        return true;
    }

    public boolean queenLV() {
        Random rnd = new Random();
        int count = 1;
        int k = 1;
        while (count > 0 && k <= n) {
            count = 0;
            for (int i = 1; i <= n; i++) {
                x[k] = i;
                if (place(k)) y[count++] = i;
            }
            if (count > 0) x[k++] = y[Math.abs(rnd.nextInt() % count)];
        }
        return (count > 0);
    }

}
