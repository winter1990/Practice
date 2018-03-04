package practice.leetcode.ez;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        if (s == null || s.length() <= 1) {
            return true;
        }
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (int i : map.values()) {
            if (i % 2 == 1) count++;
        }
        return count <= 1;
    }
}
