package practice.leetcode.medium;

/**
 * @design
 *
 * You may assume the following rules:
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 *
 * initialize the board with n * n
 * for each call of make move (player, row, col) -> player can be 1 or 2, row and col is [0, n - 1]
 * if each move is valid, we just need to check col, row and diagonal
 * for each move, mark the point as X or O, but the purpose is to determine which player wins, check row col dia not efficient
 * to determine who wins, all elements in row / col / dia should be the same value -> to quick check winner, p1 1, p2 -1
 * sum up the col and row when player makes move, use two arrays with size n
 * if different players make move on same row / col / dia, then value will never reach n
 * for each move, update rows / col and dia -> define two integer diagonal
 * steps:
 * first, get value based on player, if 1 then 1, if 2 then -1
 * update rows and cols and diagonals
 * check value of all, if = n, return that player. relation of conditions should be ||
 */

public class DesignTicTacToe {
}

class TicTacToe {

    /** Initialize your data structure here. */
    int[] rows;
    int[] cols;
    int len;
    int diagonal1;
    int diagonal2;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        len = n;
        diagonal1 = 0;
        diagonal2 = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;
        rows[row] += val;
        cols[col] += val;

        if (row == col) {
            diagonal1 += val;
        }
        if (row + col == len - 1) {
            diagonal2 += val;
        }
        if (Math.abs(rows[row]) == len || Math.abs(cols[col]) == len || Math.abs(diagonal1) == len || Math.abs(diagonal2) == len) {
            return player;
        }
        return 0;
    }
}