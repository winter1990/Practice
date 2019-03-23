package practice.leetcode.medium;

/**
 * @array
 *
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 *
 * two scenario:
 * 1. the max subarray is in the middle of array
 * 2. the max subarray is at head and tail of array -> convert to the question to find minimum subarray
 * the question becomes: find the max(max subarray, total - minimum subarray)
 * max(max subarray sum, total - min subarray sum)
 * if all positive, just sum
 * if mixed, no affect
 * if all negative, maxSum = max(A), minSum = sum(A) -> max(maxSum, total - minSum) = 0, need to use max(A)
 * to get the max subarray
 * to get the min subarray
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE, curMax = 0, curMin = 0;
        for (int a : A) {
            total += a;
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray m = new MaximumSumCircularSubarray();
        System.out.println(m.maxSubarraySumCircular(new int[]{3,-1,2,-1}));
    }
}
