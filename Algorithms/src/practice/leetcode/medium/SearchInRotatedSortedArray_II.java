package practice.leetcode.medium;

/**
 * @binarysearch
 * @array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * nums may contain duplicates
 *
 * problems to solve:
 * 1. linear search is trivial, how to apply the binary search?
 * 2. if get middle element, how to eliminate one half
 *
 * all scenarios:
 *  a[s] a[mid] a[e]   example
 * 1    >      =       [4 2 3 3 3]
 * 2    >      <       [4 2 3 3 4]
 * 3    =      <       [3 3 3 1 2]
 * 4    =      =       [3 3 3 2 3]
 * 5    <      <       [1 2 3 3 4]
 * 6    <      =       [1 2 3 3 3]
 * 7    <      >       [3 4 5 1 2]
 * 8    =      >       [3 3 3 1 2]
 *
 * for rotated sorted array:
 *   a[mid] might be same as a[s] and a[e], [5 2 3 5 5 5 5]. cannot decide which half to go next
 *   if a[start] = a[mid] = a[end] then start++ or end--
 *   if we can find an increasing half, a[start] < a[mid]
 *     check if target is in the range of [a[start], a[mid]), then we can go to left half
 *     otherwise, right half
 *
 * why we can not use the normal check for this problem?
 *   normally, we check if a[s] < a[mid], then check if target in left half, then determine which half to go
 *   and check if a[mid] < a[e], then check if target in right half, then repeat the same
 *   else s++
 *   but notice the cases - in else block, it includes (1) and (4), so we do s++ for both (1) and (4)
 *   what if the target is the leftmost element? by doing s++, we are skipping the result
 */
public class SearchInRotatedSortedArray_II {
    public boolean search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) return true;
            if (nums[s] < nums[mid]) {
                if (target >= nums[s] && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else if (nums[s] > nums[mid]) { // right half is sorted
                if (target < nums[mid] || target > nums[e]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                s++;
            }
        }
        return false;
    }

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
}
