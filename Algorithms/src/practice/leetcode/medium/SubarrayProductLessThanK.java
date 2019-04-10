package practice.leetcode.medium;

/**
 * @array
 *
 * Your are given an array of positive integers nums.
 * Count the number of subarrays where the product of all the elements in the subarray is less than k.
 *
 * [1,1,2,3,4] k=7
 * 1, 1 1, 1 1 2, 1 1 2 3, 1 1 2 3 4
 *
 * two pointers:
 * for the subarray nums[i,j], if total < k, then any combinations is also satisfying
 * Input: nums = [1,2,3,5,4,6], k = 120, Output: 8
 *
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 0, count = 0, n = nums.length;
        long total = 1;
        while (j < n) {
            total *= nums[j];
            while (i <= j && total >= k) total /= nums[i++];
            count += (j - i + 1);
            j++;
        }
        return count;
    }
}
