package practice.leetcode.easy;

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
        int n = nums.length, robPre = 0, notRobPre = 0;
        for (int i = 0; i < n; i++) {
            int robCur = notRobPre + nums[i];
            int notRobCur = Math.max(robPre, notRobPre);
            robPre = robCur;
            notRobPre = notRobCur;
        }
        return Math.max(robPre, notRobPre);
    }

    public int rob1(int[] num) {
        int[][] dp = new int[num.length + 1][2];
        for (int i = 1; i <= num.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = num[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[num.length][0], dp[num.length][1]);
    }
}
