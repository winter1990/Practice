package practice.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @design
 * @string
 * @trie
 *
 * build the trie for each word from last char to first char
 * if we have some new input, start from root to search back
 * to save time, use string builder and remove the char if the length of sb is longer than max length of word
 */
public class StreamOfCharacters {
}

class StreamChecker {
    StringBuilder input;
    TrieNode root;
    int maxLen;
    public StreamChecker(String[] words) {
        input = new StringBuilder();
        root = new TrieNode();
        maxLen = 0;
        for (String w : words) {
            maxLen = Math.max(maxLen, w.length());
            TrieNode cur = root;
            for (int i = w.length() - 1; i >= 0; i--) {
                char c = w.charAt(i);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.isWord = true;
        }
    }

    public boolean query(char letter) {
        input.append(letter);
        if (input.length() > maxLen) input.deleteCharAt(0);
        TrieNode cur = root;
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
            if (cur.isWord) return true;
        }
        return false;
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }
    }
}