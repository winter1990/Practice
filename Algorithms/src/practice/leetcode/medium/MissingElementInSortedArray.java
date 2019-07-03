package practice.leetcode.medium;

/**
 * @array
 *
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.
 *
 * [4 7 9 10] 3 - 8
 * [2 3 5 7]  3 - 8
 *
 * method 1 - linear search
 * compare a[i] + k and a[i+1]
 *   if in the range, return value
 *   else k -= a[i+1]-a[i]-1
 */
public class MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + k >= nums[i + 1]) {
                k -= nums[i + 1] - nums[i] - 1;
            } else {
                return nums[i] + k;
            }
        }
        return nums[nums.length - 1] + k;
    }

    /**
     * method 2 - binary search
     * [2 4 6 7 9 12] 6 - 13
     *
     */
    public int missingElement1(int[] nums, int k) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[0] + k + mid <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[0] + l + k - 1;
    }
}
