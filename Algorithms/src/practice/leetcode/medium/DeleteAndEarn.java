package practice.leetcode.medium;

/**
 * Each element nums[i] is an integer in the range [1, 10000]
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points.
 * After, you must delete every element equal to nums[i] - 1 or nums[i] + 1
 *
 *
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001];
        for (int num : nums) {
            sum[num] += num;
        }
        int[] dp = new int[10001];
        dp[1] = sum[1];
        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }
        return dp[10000];
    }

    public static void main(String[] args) {
        DeleteAndEarn dae = new DeleteAndEarn();
        int[] in = new int[]{2, 2, 3, 3, 3, 4};
        dae.deleteAndEarn(in);
    }
}
