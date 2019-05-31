package practice.leetcode.medium;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with
 * 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * problems to solve:
 * 1. a * b * c < target
 * 2. count the number of triplets
 *
 * brute force
 * i = [0, n - 2)
 *   j = [i + 1, n - 1)
 *     k = [j + 1, n)
 *
 * optimization
 * i = [0, n - 2)
 *   j = [i + 1, n - 1)
 *     k = n - 1
 *     if a[i] + a[j] + a[k] < target, we do not need to continue because all the elements [j + 1, k] are smaller
 * to skip the elements, we need to sort the array first
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = nums[len - 1];
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    res += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
