package practice.leetcode.medium;

/**
 * X first, O second -> num(X)-num(O) [0,1]
 * only one player wins
 *
 *
 */
public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        if (board == null || board.length < 3) {
            return false;
        }
        if (!checkCount(board)) {
            return false;
        }
    }

    private boolean checkCount(String[] board) {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < 3; i++) {
            
        }
    }
}
