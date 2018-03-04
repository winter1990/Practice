package practice.leetcode.ez;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * "abccccdd" -> 7 (dccaccd)
 *
 * all the even numbers plus biggest odd
 *
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        boolean hasOdd = false;
        int res = 0;
        for (int i : map.values()) {
            if (i % 2 == 0) {
                res += i;
            } else {
                hasOdd = true;
                res += (i - 1);
            }
        }
        return hasOdd ? res + 1 : res;
    }

    public int longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i)); // paired
                res++;
            } else {
                set.add(s.charAt(i));
            }
        }
        return set.isEmpty() ? res * 2 : res * 2 + 1;
    }
}
