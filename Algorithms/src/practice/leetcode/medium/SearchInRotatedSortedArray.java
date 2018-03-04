package practice.leetcode.medium;

/**
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
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) { // first half is increasing
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] in = {1,3};
        int target = 4;
        SearchInRotatedSortedArray sr = new SearchInRotatedSortedArray();
        System.out.println(sr.search(in, target));
    }
}
