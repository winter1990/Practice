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
 * 1. the range of result value should be between max value in the array and the sum of the array
 * 2. we have left bound and right bound left = max, right = sum
 * 3. narrow down the left and right
 *    if we can divide the array into more than m, left = mid + 1
 *    if we cannot divide the array into m, value too large, right = mid - 1
 * 4. need to define a method to check how many can be divided
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int sum = 0, max = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }
        if (m == 1) return sum;
        int l = max, r = sum;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean valid(long target, int[] nums, int m) {
        int count = 1, total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
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
