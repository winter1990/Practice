package practice.leetcode.medium;

/*
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
 */

/**
 * words in set, check contains or not
 * search needs lookup and replace
 * if '.' a-z replace and search or check words' substring in set? NO. a.b.bc
 *
 * Trie:
 * if '.' continue
 */
public class AddAndSearchWord_DataStructureDesign1 {

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String val = "";
        public TrieNode() {}
    }

    private TrieNode root;
    /** Initialize your data structure here. */
    public AddAndSearchWord_DataStructureDesign1() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.val = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return !node.val.equals("");
        }
        if (word.charAt(index) != '.') {
            return node.children[word.charAt(index) - 'a'] != null
            && searchHelper(word, index + 1, node.children[word.charAt(index) - 'a']);
        } else { // . case
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (searchHelper(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

