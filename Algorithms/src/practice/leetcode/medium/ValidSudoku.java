package practice.leetcode.medium;

import java.util.Arrays;

/**
 * need to use an array to check if 1-9 visited
 * row, colomn, 3*3 square
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] checker = new boolean[9];
        // row
        for (int i = 0; i < 9; i++) {
            Arrays.fill(checker, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (visited(checker, board[i][j])) return false;
            }
        }

        // column
        for (int i = 0; i < 9; i++) {
            Arrays.fill(checker, false);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                if (visited(checker, board[j][i])) return false;
            }
        }

        // square
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j+= 3) {
                Arrays.fill(checker, false);
                for (int k = 0; k < 9; k++) {
                    if (board[i + (k / 3)][j + (k % 3)] == '.') continue;
                    if (visited(checker, board[i + (k / 3)][j + (k % 3)])) return false;
                }
            }
        }
        return true;
    }

    private boolean visited(boolean[] checker, char c) {
        int val = c - '1'; // 0 to 8
        if (checker[val]) {
            return true;
        }
        checker[val] = true;
        return false;
    }
}
