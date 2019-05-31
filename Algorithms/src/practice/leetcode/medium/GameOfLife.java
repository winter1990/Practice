package practice.leetcode.medium;

/**
 * @array
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * 0 1 neighbors, 1 -> 0
 * 2 3 neighbors, 1 -> 1
 * 3+  neighbors, 1 -> 0
 * 3   neighbors, 0 -> 1
 * all the status and its changes
 *
 * define another row * col 2D array to count the neighbors and get the status next
 *
 * if we are not allowed to use extra space, in place
 * totally 4, we can use a 2-bit number to track the status for next
 * count neighbors one by one, for all neighbors & 1 to get the current status
 * second to right bit is used to track the next status
 * 0 1 neighbors, 1 -> 0 -> 01  no need to change the value
 * 2 3 neighbors, 1 -> 1 -> 11  change value to 3
 * 3+  neighbors, 1 -> 0 -> 01  no need to change the val
 * 3   neighbors, 0 -> 1 -> 10  change value from 1 to 2
 *
 * scan through all the elements in the 2d
 * count number of live neighbors using #&1
 * assign the current value with next value
 *
 * scan again, each value >> 1 to get the current status for next generation
 */

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = countLiveNeighbors(board, m, n, i, j);
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
        return;
    }

    public int countLiveNeighbors(int[][] board, int m, int n, int i, int j) {
        int count = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                count += board[x][y] & 1;
            }
        }
        count -= board[i][j] & 1;
        return count;
    }
}
