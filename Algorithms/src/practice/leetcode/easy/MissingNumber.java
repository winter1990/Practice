package practice.leetcode.easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        return (1 + n) * n / 2 - total;
    }
}
