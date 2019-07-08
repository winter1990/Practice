package practice.leetcode.easy;

/**
 * @array
 * @greedy
 *
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most
 * 1 element.
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 *
 * for two adjacent values a[i] and a[i+1], three cases:
 *   1 a[i] = a[i+1], no change
 *   2 a[i] < a[i+1], no change
 *   3 a[i] > a[i+1], need to modify the array
 * two options for case 3, a[i] > a[i+1]:
 *   decrease a[i]
 *     change a[i] to a[i+1]
 *     need to make sure a[i] >= a[i-1]
 *   increase a[i+1]
 *     change a[i+1] to a[i], which is the minimum value for a[i+1]
 */
public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                ++count;
                if (count > 1) return false;
                if (i > 0 && nums[i - 1] > nums[i + 1]) nums[i + 1] = nums[i];
            }
        }
        return count <= 1;
    }
}
