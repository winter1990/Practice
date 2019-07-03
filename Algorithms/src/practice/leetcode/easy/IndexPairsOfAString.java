package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @trie
 *
 * Given a text string and words (a list of strings), return all index pairs [i, j] so that the substring
 * text[i]...text[j] is in the list of words.
 *
 * Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
 * Output: [[3,7],[9,13],[10,17]]
 */
public class IndexPairsOfAString {
    public int[][] indexPairs(String text, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(word, root);
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            search(text, i, root, list);
        }
        int[][] res = new int[list.size()][2];
        int index = 0;
        for (int[] i : list) {
            res[index++] = i;
        }
        return res;
    }

    private void search(String text, int start, TrieNode root, List<int[]> res) {
        TrieNode cur = root;
        for (int i = start; i < text.length(); i++) {
            int index = text.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return;
            }
            cur = cur.children[index];
            if (cur.isWord) {
                res.add(new int[]{start, i});
            }
        }
    }

    private void insert(String word, TrieNode root) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    public static void main(String[] args) {
        String s = "ababa";
        String[] words = {"aba","ab"};
        IndexPairsOfAString i = new IndexPairsOfAString();
        i.indexPairs(s, words);
    }
}
