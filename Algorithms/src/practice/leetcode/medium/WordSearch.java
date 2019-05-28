package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @array
 * @search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * same char can not be used twice, so define a checker[][] to track whether visited
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * dfs
 * base case: 1) out of boundary 2) word found - index = length 3) visited already
 * search in 4 directions
 * recursive call (board, word, i, j, boolean[][])
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j] && findWord(board, word, 0, i, j, visited)) return true;
                initializeChecker(visited);
            }
        }
        return false;
    }

    private void initializeChecker(boolean[][] visited) {
        for (boolean[] arr : visited) Arrays.fill(arr, false);
    }

    private boolean findWord(char[][] board, String w, int index, int i, int j, boolean[][] visited) {
        if (index == w.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || w.charAt(index) != board[i][j]) return false;
        visited[i][j] = true;
        if (findWord(board, w, index + 1, i - 1, j, visited)
                || findWord(board, w, index + 1, i + 1, j, visited)
                || findWord(board, w, index + 1, i, j - 1, visited)
                || findWord(board, w, index + 1, i, j + 1, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    /**
     * alternative method without checker
     * we must find a method to track the character we have visited
     * if no extra space is allowed, do it in-place replace the visited as some special character
     * when we finish the recursive call, change it back to original character
     */
    private boolean exist(char[][] board, int i, int j, String w, int index) {
        if (index == w.length()) return true;
        if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != w.charAt(index)) return false;
        board[i][j] = '*';
        boolean result = exist(board, i - 1, j, w, index + 1) ||
                exist(board, i, j - 1, w, index + 1) ||
                exist(board, i, j + 1, w, index + 1) ||
                exist(board, i + 1, j, w, index + 1);
        board[i][j] = w.charAt(index);
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "EFDEES"));
    }


}
