package practice.leetcode.hard;

/**
 * @array
 * @daq
 * @binarysearch
 *
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2
 *
 * intuition sol:
 * use a pre sum array and get sum of subarray - O(N^2)
 *
 * optimization:
 * merge sort solution
 *
 */
public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) preSum[i + 1] = preSum[i] + nums[i];
        return countWhileMergeSort(preSum, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper)
                + countWhileMergeSort(sums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
            cache[r] = sums[i];
            count += j - k;
        }
        return count;
    }

    /**
     * brute force solution:
     * use an array to store the pre sum of the array
     * O(N^2) to calculate the sum of sub array
     *   if in the bound, res++
     */
    public int countRangeSum1(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) preSum[i + 1] = preSum[i] + nums[i];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (preSum[j] - preSum[i] >= lower && preSum[j] - preSum[i] <= upper) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {-2, 5, -1, 1, 4};
        CountOfRangeSum crs = new CountOfRangeSum();
        System.out.println(crs.countRangeSum(input, -2, 2));
    }
}
