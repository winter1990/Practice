package practice.leetcode.easy;

/**
 * @array
 *
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * calculate pre sum of the give array
 * we call sum(i,j) which means all the elements [i, j] inclusive
 * preSum[n+1]
 *   preSum[i] represents the sum of first i elements
 *   preSum[i] = preSum[i-1]+arr[i-1]
 *   sum[i,j] = preSum[j+1]-preSum[i] -> result to return
 */
public class RangeSumQuery_Immutable {
    class NumArray {
        int[] preSum;
        public NumArray(int[] nums) {
            int n = nums.length;
            preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return preSum[j + 1] - preSum[i];
        }
    }
}

