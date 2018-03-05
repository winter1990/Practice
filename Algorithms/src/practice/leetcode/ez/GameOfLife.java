package practice.leetcode.ez;

/*
Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by over-population..
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

1. [0,2) die 0
2. [2,3] live on to next generation 1->1
3. (3,) die
4. [3] 0->1
 */


public class GameOfLife {
    // use two bits to represent the state, first digit current, second digit next generation
    // initial state: 0 or 1 which is 00 or 01
    //    next    current
    // 00 die  <- die     [0,1]
    // 10 live <- die     [3]
    // 01 die  <- live    (3,)
    // 11 live <- live    [2,3]
    // current state: board[i][j]&1
    // next state: board[i][j]>>1
    public void gameOfLife(int[][] board) {
        if (board== null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                int val = helper(board, i, j, m, n);
                if (board[i][j] == 1 && (val == 2 || val == 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && val == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int helper(int[][] board, int i, int j, int m, int n) {
        int live = 0;
        for (int a = Math.max(0, i - 1); a <= Math.min(m - 1, i + 1); a++) {
            for (int b = Math.max(0, j - 1); b <= Math.min(n - 1, j + 1); b++) {
                if (a == i && b == j) {
                    continue;
                }
                live += board[a][b] & 1;
            }
        }
        return live;
    }

    public void printArr(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void gameOfLife1(int[][] board) {
        if (board== null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = helper1(board, i, j, m, n);
                if (val == 0 || val == 1) {
                    res[i][j] = 0;
                } else if (board[i][j] == 1 && (val == 2 || val == 3)) {
                    res[i][j] = 1;
                } else if (val > 3) {
                    res[i][j] = 0;
                } else if (board[i][j] == 0 && val == 3) {
                    res[i][j] = 1;
                }
            }
        }
    }

    private int helper1(int[][] board, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        } else if (board[i][j] == 1) {
            return 1;
        } else if (board[i][j] == 0) {
            return 0;
        }
        return helper(board,i - 1, j, m, n)
                + helper(board,i + 1, j, m, n)
                + helper(board,i, j + 1, m, n)
                + helper(board,i, j - 1, m, n)
                + helper(board,i + 1, j + 1, m, n)
                + helper(board,i + 1, j - 1, m, n)
                + helper(board,i - 1, j + 1, m, n)
                + helper(board,i - 1, j - 1, m, n);
    }
}
