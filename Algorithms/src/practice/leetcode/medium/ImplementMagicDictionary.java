package practice.leetcode.medium;

import java.util.*;

/**
 * @string
 * @search
 *
 * For the method search, you'll be given a word, and judge whether if you modify exactly one character
 * into another character in this word, the modified word is in the dictionary you just built.
 *
 * [hallo hillo]
 * hallo is true, it matches hillo
 */
public class ImplementMagicDictionary {
}

class MagicDictionary {
    Map<String, List<Character>> map;
    public MagicDictionary() {
        map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < sb.length(); i++) {
                sb.setCharAt(i, '.');
                if (!map.containsKey(sb.toString())) {
                    List<Character> list = new LinkedList<>();
                    list.add(word.charAt(i));
                    map.put(sb.toString(), list);
                } else {
                    map.get(sb.toString()).add(word.charAt(i));
                }
                sb.setCharAt(i, word.charAt(i));
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, '.');
            if (map.containsKey(sb.toString())) {
                for (char c : map.get(sb.toString())) {
                    if (c != word.charAt(i)) {
                        return true;
                    }
                }
            }
            sb.setCharAt(i, word.charAt(i));
        }
        return false;
    }
}


class MagicDictionary1 {
    Set<String> set;
    public MagicDictionary1() {
        set = new HashSet<>();
    }

    public void buildDict(String[] dict) {
        for (String word : dict) {
            set.add(word);
        }
    }

    public boolean search(String word) {
        for (String s : set) {
            if (s.length() != word.length()) {
                continue;
            }
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != word.charAt(i)) {
                    cnt++;
                }
            }
            if (cnt == 1) {
                return true;
            }
        }
        return false;
    }
}
