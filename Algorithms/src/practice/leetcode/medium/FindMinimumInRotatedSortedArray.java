package practice.leetcode.medium;

/**
 * @array
 * @binarysearch
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * Find the minimum element.
 * no duplicate exists in the array.
 *
 * [0 1 2 3 4 5 6 7]
 * [6 7 0 1 2 3 4 5]
 * [3 4 5 6 7 0 1 2]
 * observation:
 * if sorted array is rotated, there MUST be half of the array is in ascending order
 *
 * binary search
 * get the element in the middle, find the ascending half:
 *   if a[s] < a[mid] the smallest might be in leftmost or right half. condition cannot be used
 *   if a[s] < a[e], then start is the smallest
 *   if a[mid] < a[e], the smallest must be on left half [s, mid]
 *   else, s = mid + 1
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }
}
