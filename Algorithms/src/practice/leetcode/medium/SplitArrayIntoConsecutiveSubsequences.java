package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @array
 *
 * You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into
 * several subsequences, where each subsequences consist of at least 3 consecutive integers.
 * Return whether you can make such a split.
 *
 * split them into several subsequences
 * each subsequences consist of AT LEAST 3 consecutive integers
 * 1 2 3 3 4 5     true
 * 1 2 3 3 4 4 5 5 true 1 2 3 4 5, 3 4 5
 * 1 2 3 4 4 5     false
 *
 * 1 2 3 4 5 6
 * 1 2 3 4
 *   2 3 4 5
 * 2 3 3 3 2 1 <- frequency
 * use a tree map to
 *
 * method 1 - tree map
 * start with the smallest value
 * greedily extend the chain until the end -> fre(cur+1) > freq(cur) then we continue
 * while the frequency of current value > 0, scan again until frequency is 0
 * then move on to the next smallest value -> tree map
 * time nlogn
 *
 * method 2 - map
 * use a map to track the frequency of each element
 * for an element, there are two options
 *   use current value to start a new sequence as head
 *   append it to the current existing sequence
 * use a map to get all the frequency of the elements
 * another map for tracking the existing sequences
 *   key - start value
 *   value - the length of the sequence
 */
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) freq.put(i, freq.getOrDefault(i, 0) + 1);
        Map<Integer, Integer> sub = new HashMap<>();
        for (int i : nums) {
            if (freq.get(i) == 0) {
                continue;
            }
            if (sub.getOrDefault(i, 0) > 0) {
                sub.put(i, sub.get(i) - 1);
                sub.put(i + 1, sub.getOrDefault(i + 1, 0) + 1);
            } else if (freq.getOrDefault(i + 1, 0) > 0
                    && freq.getOrDefault(i + 2, 0) > 0) {
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                sub.put(i + 3, sub.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }

    public boolean isPossible1(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        for (int i : map.keySet()) {
            while (map.get(i) > 0) {
                if (map.get(i) == 0) continue;
                int count = 1;
                int cur = i;
                while (map.get(cur) > 0) {
                    map.put(cur, map.get(cur) - 1);
                    if (map.containsKey(cur + 1) && map.get(cur + 1) > map.get(cur)) {
                        count++;
                        cur++;
                    } else {
                        break;
                    }
                }
                if (count < 3) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayIntoConsecutiveSubsequences s = new SplitArrayIntoConsecutiveSubsequences();
        int[] in = {1,1,2,2,3,3,4};
        System.out.println(s.isPossible(in));
    }
}
