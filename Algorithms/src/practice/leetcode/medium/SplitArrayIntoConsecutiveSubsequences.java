package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * split them into several subsequences, where each subsequences consist of at least 3 consecutive integers
 * 1 2 3 3 4 5     true
 * 1,2,3,3,4,4,5,5 true 1 2 3 4 5, 3 4 5
 * 1,2,3,4,4,5     false
 * 1 2 3 4 4 5 5 5 6 6 6 7
 *
 * use a map to track the frequency of each number
 * use some other data structure to track which elements have been used to form the consecutive subsequences
 *
 */
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Map<Integer, Integer> sub = new HashMap<>();
        for (int n : nums) {
            if (map.get(n) == 0) {
                continue;
            } else if (sub.getOrDefault(n, 0) > 0) {
                sub.put(n, sub.get(n) - 1);
                sub.put(n + 1, sub.getOrDefault(n + 1, 0) + 1);
            } else if (map.getOrDefault(n + 1, 0) > 0
                    && map.getOrDefault(n + 2, 0) > 0) {
                map.put(n + 1, map.get(n + 1) - 1);
                map.put(n + 2, map.get(n + 2) - 1);
                sub.put(n + 3, sub.getOrDefault(n + 3, 0) + 1);
            } else {
                return false;
            }
            map.put(n, map.get(n) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayIntoConsecutiveSubsequences s = new SplitArrayIntoConsecutiveSubsequences();
        int[] in = {1,2,3,3,4,4,5,5,6};
        System.out.println(s.isPossible(in));
    }
}
