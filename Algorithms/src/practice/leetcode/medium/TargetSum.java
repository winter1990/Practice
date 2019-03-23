package practice.leetcode.medium;

/**
 * @search
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * the range of all different combinations [-sum, sum]
 * use a dp array to store, size is 2 * sum + 1
 * for each number, two possibilities +nums[i] or -nums[i]
 * dp[i] represents number of ways to reach i
 * base case: dp[sum] = 1, which means we sum up all values
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (S > sum || S < - sum) return 0;
        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] tmp = new int[2 * sum + 1];
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (dp[j] != 0) {
                    tmp[j + nums[i]] += dp[j];
                    tmp[j - nums[i]] += dp[j];
                }
            }
            dp = tmp;
        }
        return dp[sum + S];
    }

    public int findTargetSumWays1(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        int[] res = new int[1];
        dfs(nums, S, 0, 0, res);
        return res[0];
    }

    private void dfs(int[] nums, int target, int index, int sum, int[] res) {
        if (index == nums.length) {
            if (sum == target) res[0]++;
            return;
        }
        dfs(nums, target, index + 1, sum + nums[index], res);
        dfs(nums, target, index + 1, sum - nums[index], res);
    }

    /**
     * optimization:
     */
    int result = 0;
    public int findTargetSumWays2(int[] nums, int S) {
        if(nums == null || nums.length == 0) return result;

        int n = nums.length;
        int[] sums = new int[n];
        sums[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) sums[i] = sums[i + 1] + nums[i];
        helper(nums, sums, S, 0);
        return result;
    }
    public void helper(int[] nums, int[] sums, int target, int pos){
        if (pos == nums.length) {
            if (target == 0) result++;
            return;
        }
        if (sums[pos] < Math.abs(target)) return;
        helper(nums, sums, target + nums[pos], pos + 1);
        helper(nums, sums, target - nums[pos], pos + 1);
    }
}
