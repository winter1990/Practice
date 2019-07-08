package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @array
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is
 * closest to target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * sort the array
 * the range of i: [0,n-2)
 * j=i+1,k=len-1 start and end index
 * sum up the 3 numbers and compare with target, calculate absolute value
 *
 * initial value of res
 * if res=MAX, res-target>MAX easy to get overflow.
 * can choose some big number, MAX/2
 *
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return Integer.MIN_VALUE;
        Arrays.sort(nums);
        int len = nums.length;
        int res = nums[0] + nums[1] + nums[len - 1];
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    k--;
                    while (k > j && nums[k] == nums[k + 1]) k--;
                } else {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                }
                res = Math.abs(sum - target) < Math.abs(res - target) ? sum : res;
            }
        }
        return res;
    }

    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, diff = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                } else {
                    if (Math.abs(sum - target) < diff) {
                        diff = Math.abs(sum - target);
                        res = sum;
                    }
                    if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
