package practice.leetcode.hard;

/**
 * @array
 * @dp
 * @daq
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right]
 * coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Input: [3,1,5,8], Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =              3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * dp[i][j] means the max coins to get after bursting the balloons between i and j
 * start with the first round, left bound is 0 and right bound is left + window size which start with 2
 * define an variable to check each of element between
 * for example [3 1 5 8]
 * if i = 2, it means 5 is the last balloon to burst
 * to get the maximum value for this case, max = max value to burst all balloons on the left + balloons on right
 *
 * transition function:
 * k = [2, len) which means burst 1, 2, ... len-2 balloons
 *     l = [0, len - k)
 *         r = l + k
 *         i = [l + 1, r - 1]
 *             dp[l][r] = max(dp[l][r], arr[i] * arr[l] * arr[r] + dp[l][i] + dp[i][r])
 *
 * for all hard questions, start with 1 element, then gradually expand to more elements
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int len = nums.length + 2;
        int[] arr = new int[len];
        arr[0] = arr[len - 1] = 1;
        for (int i = 0; i < nums.length; i++) arr[i + 1] = nums[i];

        int[][] dp = new int[len][len];
        for (int k = 2; k < len; k++) {
            for (int l = 0; l < len - k; l++) {
                int r = l + k;
                for (int i = l + 1; i < r; i++) {
                    dp[l][r] = Math.max(dp[l][r], arr[l] * arr[i] * arr[r] + dp[l][i] + dp[i][r]);
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        int[] in = {3,1,5,8};
        BurstBalloons bb = new BurstBalloons();
        System.out.println(bb.maxCoins(in));
    }
}
