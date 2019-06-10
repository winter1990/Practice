package practice.leetcode.medium;

/**
 * @knapsack
 * @dp
 *
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two
 * subsets such that the sum of elements in both subsets is equal.
 *
 * problem can be translated into:
 * check if some elements in a given array can sum up to some value
 * if we can pick some numbers and sum up to (sum of whole array)/2, then the sum of the rest is also total/2
 *
 * calculate sum of the array - total
 * use an array to check if the value [1 total/2] can be reached
 * dp[nums.length+1][total/2+1]
 * dp[i][j] represents whether the sum j can be formed by i numbers in array
 *
 * initial status
 *   d[0] = true
 *
 * transition function
 *   option 1 - not use current number dp[i][j]
 *   option 2 - use the current number, then dp[i-1][j-nums[i-1]]
 *
 *   for each number
 *     i = [1, n]
 *       j = [1, total/2]
 *         dp[i][j] |= dp[i-1][j-nums[i-1]]
 *
 *
 * transition function:
 * for each number in the given array
 * if we don't pick it, state dp[i][j]=dp[i-1][j]
 * if we pick the num[i], state dp[i][j]=dp[i-1][j-num[i]]
 * to conclude: dp[i][j]=dp[i-1][j] || dp[i-1][j-num[i]]
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int a : nums) sum += a;
        if (sum % 2 != 0) return false;
        boolean[][] dp = new boolean[n + 1][sum / 2 + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = (dp[i - 1][j - nums[i - 1]] || dp[i - 1][j]);
                }
            }
        }
        return dp[n][sum / 2];
    }

    // optimization:
    // reduce the space from 2D to 1D. but for the loop in j, need to start from the sum to nums[i-1]
    public boolean canPartition1(int[] nums) {
        int sum = 0, n = nums.length;
        for (int a : nums) sum += a;
        if (sum % 2 != 0) return false;
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = sum / 2; j >= nums[i - 1]; j--) {
                dp[j] |= dp[j - nums[i - 1]];
            }
        }
        return dp[sum / 2];
    }
}
