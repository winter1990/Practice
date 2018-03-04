package practice.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * eceba->ece,3
 * ecebbaa->bbaa,4
 * abaaaccc->aaaccc,6
 * need to keep track of the two chars
 * and also the last index of consequential chars
 * map
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> lastSeen = new HashMap<>();
        int low = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            lastSeen.put(s.charAt(i), i);
            if (lastSeen.size() > 2) {
                int toRemoveLastSeen = i;
                for (Integer val : lastSeen.values()) {
                    toRemoveLastSeen = Math.min(val, toRemoveLastSeen);
                }
                lastSeen.remove(s.charAt(toRemoveLastSeen));
                low = toRemoveLastSeen + 1;
            }
            max = Math.max(max, i - low + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctCharacters l = new LongestSubstringWithAtMostTwoDistinctCharacters();
        String s = "aabaaaaaaa";
        System.out.println(l.lengthOfLongestSubstringTwoDistinct(s));
    }
}
