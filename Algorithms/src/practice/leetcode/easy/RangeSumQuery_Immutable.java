package practice.leetcode.easy;

public class RangeSumQuery_Immutable {
}

/**
 * @array
 *
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * use an array to store the sum of all previous values, sum[i] = sum[0,1,...i]
 * sum[i to j] = sum[j] - sum[i - 1], i != 0 -> sum[j]-sum[i]+num[i]
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