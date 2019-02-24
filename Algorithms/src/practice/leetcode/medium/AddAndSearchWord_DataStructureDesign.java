package practice.leetcode.medium;

/**
 * @design
 * @trie
 *
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .
 * A dot means it can represent any one letter
 *
 * trie data structure is always an option in term of word search
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 */
public class AddAndSearchWord_DataStructureDesign {
}

class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
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
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, 0, root);
    }

    private boolean helper(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isWord;
        } else if (word.charAt(index) != '.' && node.children[word.charAt(index) - 'a'] == null) {
            return false;
        }
        char c = word.charAt(index);
        if ('a' <= c && c <= 'z' && node.children[c - 'a'] != null) {
            return helper(word, index + 1, node.children[c - 'a']);
        } else if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && helper(word, index + 1, node.children[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.search("add");
//        wd.search("bad");
//        wd.search(".ad");
//        wd.search("b..");
        wd.search("a");
        wd.search(".at");
        wd.addWord("bat");
        System.out.println(wd.search(".at"));
    }
    /*
    ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
            [[],      ["at"],   ["and"],    ["an"], ["add"],    ["a"], [".at"],  ["bat"],  [".at"], ["an."],["a.d."], ["b."], ["a.d"],  ["."]]
            [null,null,null,null,null,false,false,null,false,true,false,false,true,false]
            [null,null,null,null,null,false,false,null,true,true,false,false,true,false]
            */
}


