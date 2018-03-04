package practice.leetcode.ez;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null) {
            return 0;
        } else if (nums.length <= 1) {
            return nums.length;
        }
        int max = 0;
        int index = 0;
        int count = 1;
        while (index < nums.length - 1) {
            if (nums[index] < nums[index + 1]) {
                count++;
            } else {
                count = 1;
            }
            index++;
            max = Math.max(max, count);
        }
        return max;
    }
}
