package practice.leetcode.medium;

/**
 * @binarysearch
 * @array
 *
 * duplicates are allowed
 *
 * if no duplicate, the idea of binary search can be applied because there is half of the array is sorted
 * get the middle element, if target found, true
 *
 *
 */
public class SearchInRotatedSortedArray_II {
    /**
     * this solution is not correct
     * when input is [3 1 1] target = 3, we get into else block and we miss the target value
     */
    public boolean search1(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[e]) { // right half is sorted
                if (nums[mid] < target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else if (nums[s] < nums[mid]) { // left half is sorted
                if (nums[s] <= target && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else { // nums[mid] = either or both of start and end
                s++;
            }
        }
        return false;
    }

    /**
     * in this solution, the main difference is:
     * we only compare whether mid > or < start, without comparing to end
     * back to the origin of binary search, when we should update start and end indexes
     * the difference between this II and I is: duplicates
     * duplicates may affect the result when we compare mid with start and end, they might be equal
     * so the increasing becomes non-decreasing
     * after checking start < mid, the right half is non-increasing
     * then else includes all cases that start >=mid
     * if start = mid, then we do not know how to update the index (can only update start index by +1)
     * but if start > mid, we know that right half is non-decreasing
     */
    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[s] < nums[mid]) { // left half is sorted
                if (target < nums[s] || target > nums[mid]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else if (nums[s] > nums[mid]) { // right half is sorted
                if (target < nums[mid] || target > nums[e]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else { // nums[mid] = either or both of start and end
                s++;
            }
        }
        return false;
    }
}
