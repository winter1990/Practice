package practice.leetcode.easy;

/**
 * @array
 * @math
 *
 * [1 2 3], [2 3 3] [3 4 3] [4 4 4]
 * [1 1 3], [2 2 3] [3 3 3]
 * [1 1 2 3], [2 2 3 3] [3 3 4 3] [4 4 4 4]
 *
 * we always increase the smallest element in the array until reaching balanced state
 * if multiple elements are smallest [1 1 3], still the same
 *
 * sum is sum of array, n is number of elements, x is the final state of element, m is number of moves
 * sum + (n - 1) * m = x * n
 * x = min + m
 * sum + mn - m = min * n + mn
 * m = sum - min * n
 *
 * prove:
 * why smallest number always increase for every round of incremental
 * if not, smaller value becomes smaller and we will need more rounds to add up to smallest value
 * after some rounds, potentially, there might have multiple smallest values
 * all of these smallest numbers should participate in next round
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            sum += i;
            min = Math.min(min, i);
        }
        return sum - min * nums.length;
    }
}
