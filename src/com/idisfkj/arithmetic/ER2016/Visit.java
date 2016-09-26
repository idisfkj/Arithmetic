package com.idisfkj.arithmetic.ER2016;

/**
 * 拜访
 * Created by idisfkj on 16/9/24.
 */
public class Visit {
    public int merchantX = 0;
    public int merchantY = 0;

    public int countPath(int[][] map, int n, int m) {
        // write code here
        int managerX = 0;
        int managerY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    managerX = i;
                    managerY = j;
                }
                if (map[i][j] == 2) {
                    merchantX = i;
                    merchantY = j;
                }
            }
        }
        boolean left = true;
        boolean bottom = true;
        if (managerX <= merchantX && managerY >= merchantY) {
            //位于Manager左下角
            left = true;
            bottom = true;
        } else if (managerX >= merchantX && managerY >= merchantX) {
            //位于Manager左上角
            left = true;
            bottom = false;
        } else if (managerX <= merchantX && managerY <= merchantY) {
            //位于Manager右下角
            left = false;
            bottom = true;
        } else if (managerX >= merchantX && managerY <= merchantX) {
            //位于Manager右上角
            left = false;
            bottom = false;
        }
        return dp(map, managerX, managerY, left, bottom);
    }

    public int dp(int[][] map, int x, int y, boolean left, boolean bottom) {
        if (map[x][y] == -1)
            return 0;
        if (x == merchantX)
            return 1;
        if (y == merchantY)
            return 1;
        if (left && bottom) {
            //左下
            return dp(map, x + 1, y, left, bottom) + dp(map, x, y - 1, left, bottom);
        } else if (left && !bottom) {
            //左上
            return dp(map, x - 1, y, left, bottom) + dp(map, x, y - 1, left, bottom);
        } else if (!left && bottom) {
            //右下
            return dp(map, x + 1, y, left, bottom) + dp(map, x, y + 1, left, bottom);
        } else {
            //右上
            return dp(map, x - 1, y, left, bottom) + dp(map, x, y + 1, left, bottom);
        }
    }
}
