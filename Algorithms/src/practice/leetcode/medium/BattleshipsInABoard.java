package practice.leetcode.medium;

/**
 * dfs
 * search in one direction
 * the input is valid
 * if X,check left and up cells first and search right or down
 */
public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                count++;
                /* works but redundant
                if (i == 0 || j == 0) {
                    if (board[i][j] == 'X') {
                        if (i != 0 && board[i - 1][j] == 'X') continue;
                        if (j != 0 && board[i][j - 1] == 'X') continue;
                        count++;
                    }
                } else {
                    if (board[i][j] == 'X') {
                        if (board[i - 1][j] == 'X' || board[i][j - 1] == 'X') continue;
                        count++;
                    }

                }
                */
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BattleshipsInABoard bs = new BattleshipsInABoard();
        System.out.println(bs.countBattleships(new char[][]{{'X','X','X'},{'.','.','.'},{'X','X','X'}}));
    }
}
