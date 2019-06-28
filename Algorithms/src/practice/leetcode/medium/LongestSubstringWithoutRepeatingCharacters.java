package practice.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @string
 *
 * aabcdecfghjk
 * one index to track the last index
 * need to track the chars visited -> set
 * traverse the string, if
 * - set contains char, move the last index until ch(i)=char(j)
 * - set not contains char, put and continue
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (set.add(s.charAt(j))) {
                max = Math.max(max, j - i + 1);
            } else {
                while (s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
        }
        return max;
    }

    // hash map to track the index of last occurrence
    // need second index to track the start position, start from 0
    // if not contain,put<>
    // if contains, update start pos, abcbdce, max(index,map.get(char)+1)
    // update max
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }
            map.put(c, j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
