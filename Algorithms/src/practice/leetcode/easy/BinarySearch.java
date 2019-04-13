package practice.leetcode.easy;

/**
 * @binarysearch
 *
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to
 * search target in nums. If target exists, then return its index, otherwise return -1.
 *
 * start and end -> 0, len - 1
 * get mid element, check whether it equals to target
 * if exists, straightforward, if not exists eventually, two index will not be the same
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
