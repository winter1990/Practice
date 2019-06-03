package practice.leetcode.easy;

/**
 * @array
 * @slidingwindow
 *
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum
 * average value. And you need to output the maximum average value.
 *
 * translation:
 * get the maximum sum of k contiguous elements in array
 * because if sum is maximized, the sum/k must be maximized, for both positive and negative value
 *
 * get the first k elements sum, as the maximum
 * for i = [k, n-1]
 *   sum -= a[i-k]
 *   sum += a[i]
 *   update max value
 * return max/k
 */
public class MaximumAverageSubarray_I {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        double sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max / k;
    }

    public static void main(String[] args) {
        int[] in = {1,12,-5,-6,50,3};
        MaximumAverageSubarray_I m = new MaximumAverageSubarray_I();
        System.out.println(m.findMaxAverage(in, 4));

    }
}
