package practice.leetcode.medium;

/**
 * @array
 * @search
 *
 * dfs - search in one direction
 * the input is valid
 * if X,check left and up cells first and search right or down
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board
 *
 * if we see 'X' in the board, two cases:
 *   it is an independent ship
 *   it is connected to another 'X' - the same ship
 * we scan through the board, only count the number of ships
 *   check if it is connected to another X
 *   it can be either connected to left or connected to right
 *     i > 0 board[i-1][j] = X ? skip : count++
 *     j > 0 board[i][j-1] = X ? skip : count++
 */
public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    if ((i > 0 && board[i - 1][j] == 'X') || (j > 0 && board[i][j - 1] == 'X')) continue;
                    count++;
                }
            }
        }
        return count;
    }
}
