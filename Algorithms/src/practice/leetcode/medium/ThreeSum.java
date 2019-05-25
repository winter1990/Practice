package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @array
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * problems to solve:
 * 1. find triplets and sum(a,b,c) = 0
 * 2. handle the duplicates numbers in the array
 *
 * if not sorted, can only do the brute force
 * [-1 -1 -1 0 1 2 3]
 * [-1 -1 2] [-1 1 0]
 *
 * sort the array
 * fix one value i=[0,n-3]
 *   (skip duplicates a[i])
 *   two pointers j=i+1 and k=n-1
 *   if sum > 0, k--
 *   if sum < 0, j++
 *   else add to result list, j++ k-- (skip duplicates)
 * how about duplicates:
 *   if there are duplicates and more than 3 consecutively
 *     1) i should skip all the duplicates compared to previous value
 *     2) when we get the result, j and k should skip all the duplicates [-1 -1 -1 -1 0 2 2 2]
 *
 */

public class ThreeSum {
    // time O(n^2) space O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (k > j && nums[k] == nums[k + 1]) k--;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
