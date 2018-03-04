package practice.leetcode.medium;

/**
 * dynamic programming
 * [32104],false
 * [23101],true
 *
 * dp size n. dp[i]=i+Math.max(dp[i-1],i+arr[i])
 * always check current, if 0, false
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (i > 0 && i > dp[i - 1]) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(new int[]{3,2,1,1,4}));
    }
}
