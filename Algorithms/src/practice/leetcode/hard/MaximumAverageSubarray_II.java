package practice.leetcode.hard;

/**
 * @array
 *
 * Given an array consisting of n integers, find the contiguous subarray whose length is greater than or
 * equal to k that has the maximum average value. And you need to output the maximum average value.
 *
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation:
 * when length is 5, maximum average value is 10.8,
 * when length is 6, maximum average value is 9.16667.
 * Thus return 12.75.
 *
 * brute force
 * calculate presum, preSum[i] represents the sum of [0, i), the first i elements sum up
 * if we want to get sub array sum, pre[i]-pre[i-k] [1 2 3 4 5] [0 1 3 6 10 15]
 */
public class MaximumAverageSubarray_II {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) pre[i] = pre[i - 1] + nums[i - 1];
        double max = Double.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                double cur = (double) (pre[j] - pre[j - i]) / i;
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumAverageSubarray_II m = new MaximumAverageSubarray_II();
        int[] in = {65,91,27,13,3,39,78,76,0,60,27,63,36,36,47,75,38,93,35,53,71,51,5,17,72,57,90,14,20,62,53,37,6,80,2,9,71,80,38,24,40,65,39,77,53,87,4,44,32,40,49,4,43,6,73,15,63,15,81,35,78,34,24,84,67,26,45,90,6,83,66,99,1,6,76,6,45,32,50,29,72,99,33,15,5,6,82,21,74,15,56,52,50,81,88,69,7,85,59,66};
//        int[] in = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(m.findMaxAverage(in, k));
        System.out.println(m.findMaxAverage1(in, k));
    }

    public double findMaxAverage1(int[] nums, int k) {
        double l = -10001, r = 10001;
        while(l + 0.00001 < r) {
            double m = l + (r - l) / 2;
            if (canFindLargerAverage(nums, k, m)) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    private boolean canFindLargerAverage(int[] nums, int k, double x) {
        int n = nums.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) a[i] = nums[i] - x;
        double cur = 0, prev = 0;
        for (int i = 0; i < k; i++) cur += a[i];
        if (cur >= 0) return true;
        for (int i = k; i < n; i++) {
            cur += a[i];
            prev += a[i - k];
            if (prev < 0) {
                cur -= prev;
                prev = 0;
            }
            if (cur >= 0) return true;
        }
        return false;
    }
}