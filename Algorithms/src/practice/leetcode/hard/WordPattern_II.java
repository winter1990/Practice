package practice.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @string
 * @backtracking
 *
 * pattern = "abab", str = "redblueredblue", true
 * a->r b->e a->d false
 * b->ed ...
 */
public class WordPattern_II {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return helper(str, 0, pattern, 0, map, set);
    }

    private boolean helper(String str, int i, String pattern, int j, Map<Character, String> map, Set<String> set) {
        if (i == str.length() && j == pattern.length()) {
            return true;
        }
        if (i == str.length() || j == pattern.length()) {
            return false;
        }
        char c = pattern.charAt(j);
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (!str.startsWith(s, i)) {
                return false;
            }
            return helper(str, i + s.length(), pattern, j + 1, map, set);
        }
        for (int k = i; k < str.length(); k++) {
            String s = str.substring(i, k + 1);
            if (set.contains(s)) {
                continue;
            }
            map.put(c, s);
            set.add(s);
            if (helper(str, k + 1, pattern, j + 1, map, set)) {
                return true;
            }
            map.remove(c);
            set.remove(s);
        }
        return false;
    }
}
