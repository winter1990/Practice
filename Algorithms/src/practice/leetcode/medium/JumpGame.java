package practice.leetcode.medium;

/**
 * @greedy
 * @array
 *
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

    /**
     * can use single variable to track the maximum index can reach
     *
     * for each loop, update the max and compare with whether current step can be reached
     */
    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump1(new int[]{4,2,1,0,0}));
    }

}
