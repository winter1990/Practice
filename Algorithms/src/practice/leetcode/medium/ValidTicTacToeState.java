package practice.leetcode.medium;

/**
 * @array
 * @math
 *
 * X first, O second -> need to count num(X) and num(O), #X >= XO and difference should be in 0 or 1
 * check the winner: only one player wins -> X wins, or O wins or dual
 * how to win:
 * 3 in a row
 * 3 in a col
 * 3 in diagonal
 * need to check both players - X and O
 * can not happen like this?
 * x x x
 * o o x
 * o o x
 * it might happen
 * count the 3 in a row
 */
public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        if (board == null || board.length < 3) {
            return false;
        }
        int turn = checkCount(board); // turn = 0 X move next, turn = 1 O move next
        if (turn > 1 || turn < 0) {
            return false;
        }
        boolean xWin = isWinner(board, 'X');
        boolean oWin = isWinner(board, 'O');
        if ((!xWin && !oWin)
                || (!xWin && oWin && turn == 0)
                || (xWin && !oWin && turn == 1)) {
            return true;
        }
        return false;
    }

    private boolean isWinner(String[] board, char c) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) return true;
        }
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == c && board[1].charAt(j) == c && board[2].charAt(j) == c) {
                return true;
            }
        }
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) return true;
        return false;
    }

    private int checkCount(String[] board) {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    countX++;
                } else if (board[i].charAt(j) == 'O') {
                    countO++;
                }
            }
        }
        return countX - countO;
    }

    /**
     * @recursion
     *
     *
     */
    public boolean validTicTacToe1(String[] board) {
        int countX = 0;
        int countO = 0;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'X') countX++;
                if (c == 'O') countO++;
            }
        }
        if (countX - countO > 1 || countX < countO) {
            return false;
        }
        char[] arr = (board[0] + board[1] + board[2]).toCharArray();
        // diagonal
        int winState = helper(arr[0], arr[4], arr[8]);
        winState += helper(arr[6], arr[4], arr[2]);
        // row & column
        for (int i = 0; i < 3; i++) {
            winState += helper(arr[i*3], arr[i*3+1], arr[i*3+2]);
            winState += helper(arr[i], arr[i+3], arr[i+6]);
        }
        return winState == 0 || (winState == -10 && countO == countX) || (winState == 1 && countO + 1 == countX);
    }

    private int helper(char c1, char c2, char c3) {
        if (c1 != ' ' && c1 == c2 && c2 == c3) {
            return c1 == 'X' ? 1 : -10;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] str = {"OOX",
                        "OX ",
                        "XX "};
        ValidTicTacToeState v = new ValidTicTacToeState();
        System.out.println(v.validTicTacToe1(str));
    }
}
