package practice.leetcode.easy;

/**
 * if m moves are needed, sum=nums[0,1,2...n-1], total n numbers in array
 * sum+(n-1)*m = x*n
 * x=min+m
 * sum +mn - m = min*n + mn
 * sum - m = min * n
 * m = sum - min * n
 *
 * prove:
 * why all the moves must be applied to minimum value?
 *
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            sum += i;
            min = Math.min(min, i);
        }
        return sum - min * nums.length;
    }
}
