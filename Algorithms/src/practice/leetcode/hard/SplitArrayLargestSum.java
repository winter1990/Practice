package practice.leetcode.hard;

/**
 * @array
 *
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty
 * continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 *
 * nums = [7,2,5,10,8], m = 2
 * Output: 18, [7 2 5] and [10 8]
 *
 * [15 3 2 20 6 12 5 12] 4 -> 15 3 2 | 20 | 6 12 | 5 12
 * sum = 75, 75 / 4 = 18.75 so the smallest is 19
 * we cannot calculate like this because we cannot guarantee that the subarray can be grouped and sum is close to sum/m
 * for example [20 19 18 1 2 4], m = 3
 *
 * target - minimize the largest sum
 * [1 3 4 50], m = 3
 * the range of result value should be between max value in the array and the sum of the array
 * we have left bound and right bound left = max, right = sum
 * narrow down the left and right
 *   if we can divide the array into more than m, left = mid + 1
 *   if we cannot divide the array into m, value too large, right = mid - 1
 * need to define a method to check how many can be divided
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int lo = 0, hi = 0;
        for (int n : nums) {
            lo = Math.max(lo, n);
            hi += n;
        }
        if (m == 1) return hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isValidSplit(nums, mid, m)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean isValidSplit(int[] nums, int target, int m) {
        int count = 1, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > target) {
                sum = nums[i];
                ++count;
                if (count > m) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum sa = new SplitArrayLargestSum();
        int[] in = {7,2,5,10,8};
        sa.splitArray(in, 2);
    }
}
