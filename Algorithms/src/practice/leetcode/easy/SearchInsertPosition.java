package practice.leetcode.easy;

/**
 * @binarysearch
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * no duplicates in the array
 *
 * binary search
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 *
 * if no duplicates in the array, there are two cases:
 * 1. target exists in the array - the index of target is the insertion position
 * 2. target not exists - insertion position is the leftmost element that is larger than target
 *
 * binary search:
 * s = 0, e = n - 1, get mid
 * if arr[mid] ? target
 *   = return mid
 *   < s = mid + 1
 *   > e = mid - 1
 * return s
 *
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}
