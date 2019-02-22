package practice.leetcode.medium;

/**
 * @array
 * @binarysearch
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * no duplicate exists in the array.
 *
 * 0 1 2 3 4 5 6 7 -> 5 6 7 0 1 2 3 4
 * binary search
 * get the element in the middle, compare with start
 * if start < mid? we can not determine anything, the smallest might be in leftmost or right half
 * if start < end, then start is the smallest
 * if mid < end, must in left half, e = mid
 * else start = mid + 1
 * [2 1]
 * return nums[start]
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            int mid = (start + end) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }
}
