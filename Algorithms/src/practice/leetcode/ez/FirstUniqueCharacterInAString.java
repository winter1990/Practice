package practice.leetcode.ez;

import java.util.HashMap;
import java.util.Map;

/**
 * You may assume the string contain only lowercase letters.
 *
 * map
 * if over once, -1
 * otherwise, index
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        if (s == null || s.length() == 0) {
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), -1);
            }
        }

        int index = -1;
        for (int i : map.values()) {
            if (i != -1) {
                index = index == -1 ? i : Math.min(index, i);
            }
        }
        return index;
    }
}
