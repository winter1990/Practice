package practice.leetcode.medium;

/**
 * @array
 * @binarySearch
 *
 * return the target index, or -1
 * 01235678->35678012
 * 01235678->78012356
 * no duplicates
 *
 * left most > right most
 * if partition in 2, must be one subarray is increasing
 * binary search:
 * mid=target
 * find the increasing part, s&e with target
 * in the range, bs
 *
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                return mid;
            }
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
