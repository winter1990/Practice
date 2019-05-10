package practice.leetcode.medium;

/**
 * @array
 * @binarysearch
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * return the target index, or -1
 * 01235678 -> 3 5 6 7 8 0 1 2
 *          -> 7 8 0 1 2 3 5 6
 *
 * linear search is trivial
 * for binary search
 *   if we get the middle, we can only make sure half of the array is sorted
 *     find the sorted half - it can be left or right subarray
 *       check if the target is in the range of sorted part and update the left and right pointers
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) return mid;
            if (nums[s] <= nums[mid]) { // < covers most of cases, but for [1],4 it would be stackoverflow
                if (nums[s] <= target && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else if (nums[mid] < nums[e]) {
                if (nums[mid] < target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] in = {1,2};
        int target = 1;
        SearchInRotatedSortedArray sr = new SearchInRotatedSortedArray();
        System.out.println(sr.search(in, target));
    }
}
