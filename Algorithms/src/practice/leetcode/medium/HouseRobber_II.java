package practice.leetcode.medium;

/**
 * @do
 *
 * the houses are circle. so if rob the 0 house, we will not able to get the last n - 1
 * we already know how to rob houses in a line
 * so there are two scenarios:
 * we rob [0, n - 2]
 * we rob [1, n - 1] inclusively
 * at last we compare the two values and get maximum
 */
public class HouseRobber_II {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int robFirst = nums[0] + rob(nums, 2, nums.length - 2);
        int notRobFirst = rob(nums, 1, nums.length - 1);
        return Math.max(robFirst, notRobFirst);
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
