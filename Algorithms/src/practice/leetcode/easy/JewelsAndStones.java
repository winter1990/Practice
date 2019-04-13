package practice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        if (S == null || S.length() == 0) {
            return 0;
        }
        for (char c : J.toCharArray()) set.add(c);
        int count = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
