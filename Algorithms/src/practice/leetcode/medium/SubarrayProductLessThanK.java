package practice.leetcode.medium;

/**
 * @array
 *
 * Your are given an array of positive integers nums.
 *
 * Count the number of subarrays where the product of all the elements in the subarray is less than k.
 *
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 *
 * two pointers
 * j = [0, n-1]
 *   get multiplication
 *   while (larger than target) move the left pointer
 *   every time we get a new element in array, we are adding (j-i+1) sub arrays
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0, n = nums.length;
        long total = 1;
        for (int i = 0, j = 0; j < n; j++) {
            total *= nums[j];
            while (i <= j && total >= k) total /= nums[i++];
            count += (j - i + 1);
        }
        return count;
    }
}
