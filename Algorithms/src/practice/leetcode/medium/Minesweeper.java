package practice.leetcode.medium;

/**
 * @search
 *
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of
 * its adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8')
 * representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 *
 * 1. if user clicks on 'M', mark it 'X' and stop the game
 * 2. if user clicks on 'E'
 * 2.1. no adjacent mines revealed -> 'B' -> continue with surrounding 8
 * 2.2. has adjacent mine(s), mark as the number
 *
 */
public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') { // Mine
            board[row][col] = 'X';
        } else {
            int count = countMines(board, row, col);
            if (count > 0) {
                board[row][col] = (char) ('0' + count);
            } else {
                board[row][col] = 'B';
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c >= n) continue;
                        if (board[r][c] == 'E') {
                            updateBoard(board, new int[] {r, c});
                        }
                    }
                }
            }
        }
        return board;
    }

    private int countMines(char[][] board, int row, int col) {
        int m = board.length, n = board[0].length;
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i, c = col + j;
                if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                if (board[r][c] == 'M' || board[r][c] == 'X') count++;
            }
        }
        return count;
    }
}
