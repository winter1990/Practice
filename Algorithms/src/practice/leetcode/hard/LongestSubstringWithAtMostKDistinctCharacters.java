package practice.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @string
 * @slidingwindow
 *
 * use a map to keep track to the characters and frequency
 * use two pointers, both start from 0
 * if for each character, put a new entry or update the frequency
 * when map size > k, it means more than k different chars in the window, move left pointer each time and update frequency
 * keep moving left pointer until map.get(left) = 0, remove from map
 * update max
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
