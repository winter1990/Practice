package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @string
 * @search
 *
 * For the method search, you'll be given a word, and judge whether if you modify exactly one character
 * into another character in this word, the modified word is in the dictionary you just built.
 *
 * [hallo hillo]
 * hallo
 */
public class ImplementMagicDictionary {
}

class MagicDictionary {
    Set<String> set;
    Set<String> dict;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        set = new HashSet<>();
        dict = new HashSet<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            this.dict.add(word);
            for (int i = 0; i < word.length(); i++) {
                set.add(word.substring(0, i) + "." + word.substring(i + 1));
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String tmp = word.substring(0, i) + "." + word.substring(i + 1);
            if (set.contains(tmp) && !dict.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
