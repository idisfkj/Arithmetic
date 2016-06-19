package com.idisfkj.arithmetic.search;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by idisfkj on 16/5/24.
 */
public class RandomDot {


    public static void main(String[] args) {
        RandomDot dot = new RandomDot();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入投点个数:");
        double result = dot.Darts(scanner.nextInt());
        System.out.println("结果为:" + result);
    }

    public double Darts(int n) {
        int k = 0;
        for (int i = 1; i <= n; i++) {
            Random rnd = new Random();
            double x = rnd.nextDouble();
            double y = rnd.nextDouble();
            if ((x * x + y * y) <= 1) k++;
        }
        System.out.println(k);
        return k / (double) n;
    }
}
