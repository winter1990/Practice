package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @string
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 *
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 *
 *
 * for two strings a and b, there are two cases cases can form a new palindrome string:
 *   prefix of a + rest of a (palindrome) + b
 *   a + prefix of b (palindrome) + rest of b
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            buildTrie(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }
        return res;
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.index));
            }
            root = root.children[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }
        for (int j : root.list) {
            if (j == i) continue;
            res.add(Arrays.asList(i, j));
        }
    }
    private void buildTrie(TrieNode root, String w, int index) {
        for (int i = w.length() - 1; i >= 0; i--) {
            char c = w.charAt(i);
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new TrieNode();
            }
            if (isPalindrome(w, 0, i)) root.list.add(index);
            root = root.children[c - 'a'];
        }
        root.list.add(index);
        root.index = index;
    }

    private boolean isPalindrome(String w, int i, int j) {
        while (i < j) {
            if (w.charAt(i) != w.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    class TrieNode {
        int index;
        TrieNode[] children;
        List<Integer> list;
        public TrieNode() {
            index = -1;
            children = new TrieNode[26];
            list = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        PalindromePairs p = new PalindromePairs();
        System.out.println(p.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
    }
}
