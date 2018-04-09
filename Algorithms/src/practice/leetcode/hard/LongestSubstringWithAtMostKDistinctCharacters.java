package practice.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @string
 * @slidingwindow
 *
 * use a map to keep track to the characters and frequency
 *
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
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
