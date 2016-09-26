package com.idisfkj.arithmetic.ER2016;

import java.util.Scanner;

/**
 * 裁剪网纸
 * 随机的点坐标,找出最小的正方形包围所以的点
 * Created by idisfkj on 16/9/24.
 */
public class Crop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
            }
            int max = Math.max(maxX - minX, maxY - minY);
            System.out.println(max * max);
        }
    }
}
