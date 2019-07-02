package practice.leetcode.easy;

/**
 * @array
 *
 * board.length == board[i].length == 8
 * board[i][j] is either 'R', '.', 'B', or 'p'
 * There is exactly one cell with board[i][j] == 'R'
 *
 * rook can go 4 directions, up down left and right
 * it cannot skip and friendly bishops
 *
 * find the rook first
 * check all the 4 directions, if see B, then stop searching
 * otherwise if see p, then count++, break
 * if see B, break. as it's friendly bishop we can not go further
 */
public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int xr = 0, yr = 0;
        int n = 8;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    xr = i;
                    yr = j;
                    break;
                }
            }
        }
        int count = 0;
        for (int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}) {
            for (int x = xr + dir[0], y = yr + dir[1]; x >= 0 && x < n && y >= 0 && y < n; x += dir[0], y += dir[1]) {
                if (board[x][y] == 'p') {
                    count++;
                    break;
                }
                if (board[x][y] == 'B') break;
            }
        }
        return count;
    }

    public int numRookCaptures1(char[][] board) {
        int m = board.length, n = board[0].length, count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[] rook = new int[2];
        a:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    rook[0] = i;
                    rook[1] = j;
                    break a;
                }
            }
        }
        for (int[] d : dirs) {
            int x = rook[0];
            int y = rook[1];
            while (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != 'B') {
                if (board[x][y] == 'p') {
                    count++;
                    break;
                }
                x += d[0];
                y += d[1];

            }
        }
        return count;
    }
}