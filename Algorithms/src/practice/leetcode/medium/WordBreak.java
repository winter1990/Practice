package practice.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @dp
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words
 *
 * intuitive solution:
 * recursively check substring
 * this will fail if the string is to long
 * aaaaaaaaaaaaaaaaaaaaaaaaaa...,[a,aa,aa,aaa]
 *
 * optimization:
 * use an array - boolean[n+1]
 * dp[i] means the substring(0, i) can be segmented into one or multiple words
 * initialize start point 0 true
 * i = [1, n] - current substring [0, i)
 *   j = [0,i)
 *     if dp[j] = true and the substring [j,i) contains in the dictionary
 *     then it means the substring [0,i) can be divided into multiple
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * followup
     * what if we need to call search(string s) multiple times
     *
     * use a trie to build the dictionary so if we call search(word), we do not have to do O(N^2) search each time
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) addToTree(root, word);
        int n = s.length();
        boolean[] checker = new boolean[n + 1];
        checker[n] = true;
        char[] cs = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            TrieNode cur = root;
            for (int j = i; j < n && cur != null; j++) {
                int index = (int) cs[j];
                cur = cur.nodes[index];
                if (cur != null && cur.isWord && checker[j + 1]) {
                    checker[i] = true;
                    break;
                }
            }
        }
        return checker[0];
    }

    private void addToTree(TrieNode root, String w) {
        TrieNode node = root;
        for (int i = 0; i < w.length(); i++) {
            int index = (int) w.charAt(i);
            if (node.nodes[index] == null) {
                node.nodes[index] = new TrieNode();
            }
            node = node.nodes[index];
        }
        node.isWord = true;
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] nodes;
        public TrieNode() {
            isWord = false;
            nodes = new TrieNode[128];
        }
    }

    public static void main(String[] args) {
        String s = "leetcodee";
        List<String> list = new LinkedList<>();
        list.add("leet");
        list.add("code");
        list.add("de");
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak(s, list));
    }
}
