package practice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * use map to track the frequency
 * if contains freq+1
 * if not add
 * always check left and right number and compute the total, compare with max
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
            int left = map.getOrDefault(i - 1, 0);
            int right = map.getOrDefault(i + 1, 0);
            if (left == 0 && right == 0) {
                continue;
            }
            max = Math.max(max, map.get(i) + Math.max(left, right));
        }
        return max;
    }

    // get left, get right O(1), Math.max() takes time
    // a little optimization, not check left and right every time
    public int findLHS1(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (long n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = 0;
        for (long l : map.keySet()) {
            if (map.containsKey(l + 1)) {
                max = Math.max(max, map.get(l) + map.get(l + 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubsequence l = new LongestHarmoniousSubsequence();
        int[] in = {1,1,1,4,1,2,4};
        System.out.println(l.findLHS(in));
    }
}
