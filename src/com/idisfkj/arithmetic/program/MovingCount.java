package com.idisfkj.arithmetic.program;

/**
 * 机器人的运动范围
 * 一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。
 * Created by idisfkj on 16/9/22.
 */
public class MovingCount {

    public int[][] flag;
    public int threshold;
    public int count = 0;
    public int rows;
    public int clos;

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(5, 10, 10) + "");
    }

    public int movingCount(int threshold, int rows, int cols) {
        flag = new int[rows][cols];
        this.threshold = threshold;
        this.rows = rows;
        this.clos = cols;
        bfs(0, 0);
        return count;
    }

    public void bfs(int i, int j) {
        flag[i][j] = 1;
        if ((getAllDigitSum(i) + getAllDigitSum(j)) > threshold) {
            return;
        }
        count++;
        //向左移动
        if (j - 1 >= 0 && flag[i][j - 1] == 0) {
            bfs(i, j - 1);
        }
        //向右移动
        if (j + 1 < clos && flag[i][j + 1] == 0) {
            bfs(i, j + 1);
        }
        //向下移动
        if (i + 1 < rows && flag[i + 1][j] == 0) {
            bfs(i + 1, j);
        }
        //向上移动
        if (i - 1 >= 0 && flag[i - 1][j] == 0) {
            bfs(i - 1, j);
        }
    }

    public int getAllDigitSum(int num) {
        int result = 0;
        String temp = String.valueOf(num);
        for (int i = 0; i < temp.length(); i++) {
            //整数值字符变成整数要减去字符'0'
            result += temp.charAt(i) - '0';
        }
        return result;
    }
}
