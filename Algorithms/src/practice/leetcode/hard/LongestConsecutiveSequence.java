package practice.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        // O(n) time. use a set to store all numbers
        // every time we visit a number, check left and right adjacent numbers
        // if find left, continue searching to left. same as right. and also delete original number

        if (num == null || num.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        for (int i : num) {
            set.add(i);
        }

        int max = 1;
        for (int i : num) {
            int count = 1;
            int l = i - 1;
            int r = i + 1;
            while (set.contains(l)) {
                set.remove(l);
                count++;
                l--;
            }
            while (set.contains(r)) {
                set.remove(r);
                count++;
                r++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
