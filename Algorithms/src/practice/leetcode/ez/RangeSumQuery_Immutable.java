package practice.leetcode.ez;

public class RangeSumQuery_Immutable {
}

/*
Given nums = [-2, 0, 3, -5, 2, -1]
sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
 */

class NumArray {
    int[] nums;
    int[] sum;
    public NumArray(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = (sum[i - 1] + nums[i]);
            }
        }
    }

    public int sumRange(int i, int j) {
        return nums[i] + sum[j] - sum[i];
    }
}