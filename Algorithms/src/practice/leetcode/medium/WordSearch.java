package practice.leetcode.medium;

import java.util.Arrays;

/**
 * same char can not be used twice
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * dfs
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] checker = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j] && findWord(board, word, 0, i, j, checker)) return true;
                initializeChecker(checker);
            }
        }
        return false;
    }

    private void initializeChecker(boolean[][] checker) {
        for (int k = 0; k < checker.length; k++) {
            Arrays.fill(checker[k], false);
        }
    }

    private boolean findWord(char[][] board, String word, int index, int i, int j, boolean[][] checker) {
        if (index == word.length()) {
            return true;
        } else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        } else if (checker[i][j]) {
            return false;
        } else if (word.charAt(index) != board[i][j]) {
            return false;
        }
        checker[i][j] = true;
        if (findWord(board, word, index + 1, i - 1, j, checker)
                || findWord(board, word, index + 1, i + 1, j, checker)
                || findWord(board, word, index + 1, i, j - 1, checker)
                || findWord(board, word, index + 1, i, j + 1, checker)) {
            return true;
        }
        checker[i][j] = false;
        return false;
    }

    // alternative method without checker
    private boolean exist(char[][] board, int i, int j, String word, int ind){
        if(ind == word.length()) return true;
        if(i > board.length-1 || i <0 || j<0 || j >board[0].length-1 || board[i][j]!=word.charAt(ind))
            return false;
        board[i][j]='*';
        boolean result =    exist(board, i-1, j, word, ind+1) ||
                exist(board, i, j-1, word, ind+1) ||
                exist(board, i, j+1, word, ind+1) ||
                exist(board, i+1, j, word, ind+1);
        board[i][j] = word.charAt(ind);
        return result;
    }


    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','E','S'},
                          {'A','D','E','E'}};
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board,"EFDEES"));
    }


}
