package practice.leetcode.ez;

/**
 * @dp
 *
 * convert the problem to:
 * add numbers to max. can not add 2 adjacent nums
 *
 * start from index dp[0] dp[1] dp[2] = dp[0]+num[2]
 * i from 3 to n - 1
 */

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        return dp[n - 1] > dp[n - 2] ? dp[n - 1] : dp[n - 2];
    }

    public int rob2(int[] nums) {
        int ifRobPre = 0;
        int ifNotRobPre = 0;
        for (int i = 0; i < nums.length; i++) {
            int ifRobCur = ifNotRobPre + nums[i];
            int ifNotRobCur = Math.max(ifNotRobPre, ifRobPre);
            ifRobPre = ifRobCur;
            ifNotRobPre = ifNotRobCur;
        }
        return Math.max(ifRobPre, ifNotRobPre);
    }

    public int rob3(int[] num) {
        int[][] dp = new int[num.length + 1][2];
        for (int i = 1; i <= num.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = num[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[num.length][0], dp[num.length][1]);
    }
}
