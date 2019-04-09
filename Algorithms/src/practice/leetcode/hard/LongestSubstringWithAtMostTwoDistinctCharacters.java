package practice.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @string
 * @map
 *
 * eceba->ece,3
 * ecebbaa->bbaa,4
 * abaaaccc->aaaccc,6
 * need to keep track of the two chars
 * and also the last index of consequential chars
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length(), left = 0, max = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstringTwoDistinct1(String s) {
        if (s == null || s.length() == 0) return 0;
        // track the index of character that occurs last
        Map<Character, Integer> map = new HashMap<>();
        int low = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
            if (map.size() > 2) {
                int toRemoveLastSeen = i;
                for (Integer val : map.values()) {
                    toRemoveLastSeen = Math.min(val, toRemoveLastSeen);
                }
                map.remove(s.charAt(toRemoveLastSeen));
                low = toRemoveLastSeen + 1;
            }
            max = Math.max(max, i - low + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctCharacters l = new LongestSubstringWithAtMostTwoDistinctCharacters();
        String s = "ccaabbb";
        System.out.println(l.lengthOfLongestSubstringTwoDistinct(s));
        System.out.println(l.lengthOfLongestSubstringTwoDistinct1(s));
    }
}
