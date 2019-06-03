package practice.leetcode.medium;

/**
 * @array
 *
 * the rules:
 * 1. If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at
 * the same time - these positions become empty.
 * 2. After crushing all candies simultaneously, if an empty space on the board has candies on top of itself,
 * then these candies will drop until they hit a candy or bottom at the same time. (No new candies will drop
 * outside the top boundary.)
 * 3. After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the
 * above steps.
 * 4. If there does not exist more candies that can be crushed (ie. the board is stable), then return the
 * current board.
 *
 * check horizontally and vertically
 * drop the candies
 * mark the candies that should be crushed as negative
 * but san candy can be scanned for crushing row and column - before checking, get abs - also skip 0 / empty
 */
public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean nextRound = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 2; j++) {
                int v = Math.abs(board[i][j]);
                if (v > 0 && v == Math.abs(board[i][j + 1]) && v == Math.abs(board[i][j + 2])) {
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                    nextRound = true;
                }
            }
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n; j++) {
                int v = Math.abs(board[i][j]);
                if (v > 0 && v == Math.abs(board[i + 1][j]) && v == Math.abs(board[i + 2][j])) {
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
                    nextRound = true;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int b = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (board[i][j] > 0) {
                    board[b][j] = board[i][j];
                    b--;
                }
            }
            for (int i = b; i >= 0; i--) board[i][j] = 0;
        }
        return nextRound ? candyCrush(board) : board;
    }
}
