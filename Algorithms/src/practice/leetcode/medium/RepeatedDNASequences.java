package practice.leetcode.medium;

import java.util.*;

/**
 * @string
 * @slidingwindow
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule
 * use indexOf method, get substring, check indexOf again
 */
public class RepeatedDNASequences {
    public List<String> findRepeat(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if (!set.add(sub)) {
                res.add(sub);
            }
        }
        return new ArrayList(res);
    }
}
