package practice.leetcode.medium;

/**
 * @greedy
 * @array
 *
 * [3 2 1 0 4], false
 * [2 3 1 0 1], true
 *
 * method 1 - dynamic programming
 * use a dp array with size of n
 * dp[i] represents the maximum index we can reach at index i
 * dp[0] = nums[0]
 *
 *
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
            if (dp[i - 1] < i) return false;
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        return true;
    }

    /**
     * optimization:
     * the previous status is not re-used
     * we only keep track of the maximum index can be reached each time
     * so use a single variable is enough
     * for each loop, check if current index can be reached and update the max can be reached
     */
    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < i) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump1(new int[]{3,2,2,0,0,1}));
    }

}
