package practice.leetcode.hard;

import java.util.*;

/**
 * @search
 * @trie
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * build up trie
 */
public class WordSearch_II {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, root, i, j, m, n, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, TrieNode node, int i, int j, int m, int n, List<String> res) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, node, i - 1, j, m, n, res);
        if (i < m - 1) dfs(board, node, i + 1, j, m, n, res);
        if (j > 0) dfs(board, node, i, j - 1, m, n, res);
        if (j < n - 1) dfs(board, node, i, j + 1, m, n, res);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode cur = root;
            for (char c : w.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.word = w;
        }
        return root;
    }

    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
