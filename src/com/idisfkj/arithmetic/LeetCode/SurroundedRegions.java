package com.idisfkj.arithmetic.LeetCode;

/**
 * Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
 * A region is captured by flipping all'O's into'X's in that surrounded region .
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Created by idisfkj on 16/10/4.
 */
public class SurroundedRegions {
    public int[][] flag;
    public int[][] visit;

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'O'},
                {'X', 'O', 'X', 'X'}
        };
        new SurroundedRegions().solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        flag = new int[board.length][board[0].length];
        visit = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !bfs(board, i, j)) {
                    board[i][j] = 'X';
                } else {
                    visit = new int[board.length][board[0].length];
                }
            }
        }
    }

    public boolean bfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (board[i][j] == 'O') {
            if (flag[i][j] == 1)
                return true;
            if (visit[i][j] == 1)
                return false;
            if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                flag[i][j] = 1;
                return true;
            }
            visit[i][j] = 1;
            return bfs(board, i, j - 1) || bfs(board, i - 1, j) || bfs(board, i, j + 1) || bfs(board, i + 1, j);
        }
        return false;
    }
}
