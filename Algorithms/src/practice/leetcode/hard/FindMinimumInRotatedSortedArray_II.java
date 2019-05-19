package practice.leetcode.hard;

/**
 * @array
 * @search
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * Find the minimum element.
 * The array may contain duplicates.
 *
 *  0 1 2 3 4 5 6
 * [0 1 2 2 2 2 3]
 * [2 2 3 0 1 2 2]
 * [2 2 2 2 3 0 1]
 * [3 0 1 2 2 2 2]
 *
 *
 */
public class FindMinimumInRotatedSortedArray_II {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        return nums[lo];
    }
}
