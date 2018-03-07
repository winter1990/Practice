package practice.leetcode.medium;

/**
 * X first, O second -> num(X) - num(O) [0,1]
 * only one player wins
 * can not happen like this
 * x x x
 * o o x
 * o o x
 */
public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        if (board == null || board.length < 3) {
            return false;
        }
        if (checkCount(board) > 1 || checkCount(board) < 0) {
            return false;
        }
        if ((!isWinner(board, 'O') && !isWinner(board, 'X'))
                || (isWinner(board, 'O') && !isWinner(board, 'X') && checkCount(board) == 0)
                || (isWinner(board, 'X') && !isWinner(board, 'O') && checkCount(board) == 1)) {
            return true;
        }
        return false;
    }

    private boolean isWinner(String[] board, char c) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) count++;
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) count++;
        }
        if (board[1].charAt(1) == c && board[0].charAt(0) == c && board[2].charAt(2) == c) count++;
        if (board[1].charAt(1) == c && board[0].charAt(2) == c && board[2].charAt(0) == c) count++;
        if (count == 1) return true;
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
