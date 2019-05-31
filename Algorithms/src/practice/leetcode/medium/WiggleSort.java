package practice.leetcode.medium;

/**
 * @sort
 *
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 *
 * problems to solve:
 * 1. properties of the wiggle array
 * 2. how to perform the wiggle sort
 *
 * one way to form a wiggle sorted array:
 * smallest - largest - second smallest - second largest ...
 *
 * odd index are larger
 * even index are smaller
 *
 * in-place and swap:
 *   if odd index, compare with previous element
 *     if smaller then swap - odd is larger and previous even indexed number becomes smaller
 *   if even index and not 0, compare with previous element, if larger then swap
 *   so previous odd indexed value becomes larger
 */

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
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




