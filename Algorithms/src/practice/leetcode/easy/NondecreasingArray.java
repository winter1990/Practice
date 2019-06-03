package practice.leetcode.easy;

/**
 * @array
 *
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most
 * 1 element.
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 *
 * if see two adjacent elements that a[i] > a[i+1], there are two options:
 *   decrease a[i], the largest value it can be is a[i+1] and a[i] >= a[i-1]
 *   increase a[i+1], the smallest value a[i+1] can be is a[i]
 *
 */
public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) return false;
                if (i > 0 && nums[i - 1] > nums[i + 1]) nums[i + 1] = nums[i];
            }
        }
        return count <= 1;
    }
}
