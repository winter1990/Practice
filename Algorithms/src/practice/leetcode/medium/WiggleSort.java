package practice.leetcode.medium;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;

/**
 * @sort
 *
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 *
 * smallest-largest-second smallest-second largest...
 * odd index are increasing
 * even index are decreasing
 *
 */

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i] < nums[i - 1]) swap(nums, i);
            } else {
                if (i != 0 && nums[i] > nums[i - 1]) swap(nums, i);
            }
        }
    }

    private void swap(int[] nums, int i) {
        int tmp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = tmp;
    }
}




