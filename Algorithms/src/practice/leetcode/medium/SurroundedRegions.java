package practice.leetcode.medium;

import java.util.Queue;

/**
 * @array
 * @dfs
 * @bfs
 *
 * when the region can be kept in the array?
 * only when there is one element at the edge
 * mark the area as other character besides X and O
 * then scan the board and mark O as X and change the . to O
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0, m, n);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                bfs(board, i, n - 1, m, n);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j, m, n);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[m - 1][j] == 'O') {
                bfs(board, m - 1, j, m, n);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (board[i][j] == 'X' || board[i][j] == '.') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '.';
        }
        bfs(board, i + 1, j, m, n);
        bfs(board, i - 1, j, m, n);
        bfs(board, i, j + 1, m, n);
        bfs(board, i, j - 1, m, n);
    }

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] cs = new char[][]{{'O','O'},{'O','O'}};
        sr.solve(cs);
    }
}
