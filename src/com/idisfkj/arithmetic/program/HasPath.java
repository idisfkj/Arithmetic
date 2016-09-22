package com.idisfkj.arithmetic.program;

/**
 * 矩阵中的路径
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 * Created by idisfkj on 16/9/22.
 */
public class HasPath {

    public int rows;
    public int cols;
    public int[][] flag;

    public static void main(String[] args) {
        String str = "ABCESFCSADEE";
        char[] matrix = str.toCharArray();
        String str1 = "SEE";
        char[] re = str1.toCharArray();
        System.out.println(new HasPath().hasPath(matrix, 3, 4, re));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.rows = rows;
        this.cols = cols;
        char[][] temp = new char[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            temp[i / cols][i % cols] = matrix[i];
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == str[0]) {
                //重新将flag数据清零
                flag = new int[rows][cols];
                //自身访问初始为1
                flag[i / cols][i % cols] = 1;
                if (bfs(temp, i / cols, i % cols, 1, str))
                    return true;
            }
        }
        return false;
    }

    //ABCESFCSADEE",3,4,"SEE"
    //也可以使用回溯法
    public boolean bfs(char[][] matrix, int i, int j, int index, char[] str) {
        if (index == str.length) {
            return true;
        }
        boolean result = false;
        //向左移动
        if (j - 1 >= 0 && flag[i][j - 1] == 0 && matrix[i][j - 1] == str[index] && !result) {
            flag[i][j - 1] = 1;
            result = bfs(matrix, i, j - 1, index + 1, str);
        }
        //向右移动
        if (j + 1 < cols && flag[i][j + 1] == 0 && matrix[i][j + 1] == str[index] && !result) {
            flag[i][j + 1] = 1;
            result = bfs(matrix, i, j + 1, index + 1, str);
        }
        //向下移动
        if (i + 1 < rows && flag[i + 1][j] == 0 && matrix[i + 1][j] == str[index] && !result) {
            flag[i + 1][j] = 1;
            result = bfs(matrix, i + 1, j, index + 1, str);
        }
        //向上移动
        if (i - 1 >= 0 && flag[i - 1][j] == 0 && matrix[i - 1][j] == str[index] && !result) {
            flag[i - 1][j] = 1;
            result = bfs(matrix, i - 1, j, index + 1, str);
        }
        return result;
    }
}
