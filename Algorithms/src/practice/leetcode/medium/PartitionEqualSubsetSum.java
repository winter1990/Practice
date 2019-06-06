package practice.leetcode.medium;

/**
 * @knapsack
 *
 * whether some of the elements in array can sum up to some value.
 * if we can pick some numbers from array 0-i and sum up to j, then its true
 * initial state (0,0)=true
 *   0 1 2 3 4 5 6 7
 * 0 t
 * 1 t
 * 2 t
 * 7 t
 * 4 t
 * transition function:
 * for each number in the given array
 * if we don't pick it, state dp[i][j]=dp[i-1][j]
 * if we pick the num[i], state dp[i][j]=dp[i-1][j-num[i]]
 * to conclude: dp[i][j]=dp[i-1][j] || dp[i-1][j-num[i]]
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        if ((total & 1) == 1) {
            return false;
        }

        total /= 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][total + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= total; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][total];
    }

    // a little optimization: space from 2D to 1D
    public boolean canPartition1(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        if ((total & 1) == 1) {
            return false;
        }

        total /= 2;
        int len = nums.length;
        boolean[] dp = new boolean[total + 1];
        dp[0] = true; // if we dont pick any element
        for (int n : nums) {
            for (int i = total; i > 0; i--) {
                if (i >= n) {
                    dp[i] = (dp[i] || dp[i - n]);
                }
            }
        }
        return dp[total];
    }
}
