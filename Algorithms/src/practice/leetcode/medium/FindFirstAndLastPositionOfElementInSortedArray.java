package practice.leetcode.medium;

/**
 * @binarysearch
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given
 * target value.
 * If the target is not found in the array, return [-1, -1].
 *
 * Input: nums = [5,7,7,8,8,8,10]
 * target = 6 Output: [-1,-1]
 * target = 8 Output: [3,5]
 *
 * problems to solve:
 * 1. find the target value in the array
 * 2. if found, continue searching the left and right bound
 *
 * use binary search to find the element
 *   if not found, [-1 -1]
 *   if found
 *     how to determine whether we should continue searching?
 *     a[i] = target
 *       if a[i-1] = target continue to left side
 *       if a[i+1] = target continue to right side
 *     search left and right separately
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (target > nums[mid]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (nums[s] == target) {
            res[0] = s;
        } else {
            return res;
        }
        e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2 + 1;
            if (target < nums[mid]) {
                e = mid - 1;
            } else {
                s = mid;
            }
        }
        res[1] = e;
        return res;
    }

    public int[] searchRange1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[0] = findLeftBound(nums, target);
        res[1] = findRightBound(nums, target);
        return res;
    }

    private int findRightBound(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                if (mid != nums.length - 1 && nums[mid] == nums[mid + 1]) {
                    s = mid + 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    private int findLeftBound(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                if (mid != 0 && nums[mid] == nums[mid - 1]) {
                    e = mid - 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}
