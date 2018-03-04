package practice.leetcode.ez;

/**
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 */

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!strs[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                if (map.values().contains(strs[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), strs[i]);
            }
        }
        return true;
    }


    /**
     *
     */
    public boolean wordPattern1(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Map<Character, String> map = new HashMap<>();
        map.put('a', "abc");
        map.putIfAbsent('b', "abc");
        System.out.println(map.values() + " " + map.keySet());
        System.out.println(map.put('a', "abc"));
    }
}
