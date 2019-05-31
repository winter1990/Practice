package practice.leetcode.hard;

/**
 * @array
 * @binarysearch
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * Find the minimum element.
 * The array may contain duplicates.
 *
 * examples
 *  0 1 2 3 4 5 6  - index
 * [0 1 2 2 2 2 3] - sorted array
 * [2 2 3 0 1 2 2]
 * [2 2 2 2 3 0 1]
 * [3 0 1 2 2 2 2]
 *
 *  a[s] a[mid] a[e]
 * 1    =      =
 * 2    =      >
 * 3    =      <
 * 4    <      =
 * 5    <      <
 * 6    <      >
 * 7    >      =
 * 8    >      <
 * the only case that will not happen is a[s] > a[mid] > a[e]
 * which half we should consider or which element we should compare with a[mid]?
 * if we compare a[s] with a[mid], there are 3 potential cases:
 *   (1) < [4 5 6 1 2] [1 2 3]
 *   (2) = [3 1 3 3 3] [2 2 2 1 2]
 *   (3) > [7 3 4 5 6] [3 1 2 3 4]
 *   for (1)(2), min can be on either half and can be at any position
 *   for (3), min must be landed in [start, mid] inclusively, so we can set e to mid
 *   but in else we still cannot determine which half to go or which element to skip
 * if we compare a[mid] with a[e], also 3 scenarios:
 *   (1) < [5 1 2 3 4] [4 5 1 2 3] must be in left half [s, mid]
 *   (2) = [1 2 3 3 3] [3 3 3 1 3]
 *   (3) > [3 4 5 2 3]
 *   for (1) the target must be in left half [s,mid]
 *   for (2) not known
 *   for (3) must be in right half
 *
 * by listing all possible scenarios, we can see that with duplicates, the main impact is:
 *   compared to normal binary search, after checking a[s] a[mid] a[e] we know which side to go
 *   or in worst case, we can narrow down the indices start and end by 1
 * if compare a[s] and a[mid], we can not determine
 * and by comparing a[mid] and a[e], we can skipping the one element in else block by end--
 */
public class FindMinimumInRotatedSortedArray_II {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                end--;
            }
        }
        return nums[start];
    }
}
