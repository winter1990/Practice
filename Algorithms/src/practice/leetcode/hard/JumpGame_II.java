package practice.leetcode.hard;

/**
 * @greedy
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 * greedily check for each step, what is the maximum index can be reached
 * the thinking is similar to BFS
 *   use two pointers to track the range of indices can be reached for each loop
 *   start with i = 0
 *   from 0, the indices can be reached (i, i+arr[i]]
 *
 */
public class JumpGame_II {
    public int jump(int[] nums) {
        int n = nums.length, res = 0, end = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (i > max) return -1; // not necessary but it handles the no solution senario
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                res++;
                end = max;
                if (max >= n - 1) break;
            }
        }
        return res;
    }
}
