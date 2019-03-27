package practice.leetcode.ez;

import java.util.HashMap;
import java.util.Map;

/**
 * @hash
 * @string
 *
 * You may assume the string contain only lowercase letters.
 *
 * scan the string, from [0, n - 1]
 * if not contains key, put character and index into map
 * if contains key, then update the value to -1
 * scan one more time, if >= 0, return value/index, otherwise return -1
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
            if (i != -1) index = index == -1 ? i : Math.min(index, i);
        }
        return index;
    }
}
