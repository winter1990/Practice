package practice.leetcode.easy;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (nums[i] == 0) {
                cur = 0;
            } else {
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}
