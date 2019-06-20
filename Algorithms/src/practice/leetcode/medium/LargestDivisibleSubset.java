package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @dp
 * @array
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this
 * subset satisfies:
 * Si % Sj = 0 or Sj % Si = 0.
 * If there are multiple solutions, return any subset is fine.
 *
 * [1 2 4 8] -> [1 2 4 8]
 * [2 3 4 6 8 15] -> [2 4 8]
 *
 * the method is similar with Longest Increasing Subsequence
 *
 * what we need to track
 *   previous element / sequence
 *   count of the max length of the sequence
 *   maximum length of the sub sequence
 *
 * 3 6 18 true, 3 7 21 false
 * after sorting, if the value is divisible by previous smaller value, it must be divisible by all smaller sequence
 * dp[i] is the sequence with the length (i + 1)
 *
 * [2 3 4 6 7 18 36], output: [3 6 18 36]
 * [1 1 1 1 1  1  1] count
 *
 *
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int n = nums.length, max = 0, index = -1;
        int[] pre = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        Arrays.fill(pre, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && count[j] + 1 > count[i]) {
                    count[i] = count[j] + 1;
                    pre[i] = j;
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
