package practice.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
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
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(j - i + 1, max);
                j++;
            } else {
                while (s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                i += 1;
                j++;
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
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abba";
                //"daaabcd";
        System.out.print(ls.lengthOfLongestSubstring1(s));
    }
}
