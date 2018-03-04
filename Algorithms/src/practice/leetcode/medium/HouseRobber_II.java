package practice.leetcode.medium;

/**
 * the houses are circle
 * start from 0 or 1
 */
public class HouseRobber_II {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int s, int e) {
        int ifRobPre = 0;
        int ifNotRobPre = 0;
        for (int i = s; i <= e; i++) {
            int ifRobCur = nums[i] + ifNotRobPre;
            int ifNotRobCur = Math.max(ifRobPre, ifNotRobPre);
            ifRobPre = ifRobCur;
            ifNotRobPre = ifNotRobCur;
        }
        return Math.max(ifRobPre, ifNotRobPre);
    }
}
