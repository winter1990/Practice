package practice.leetcode.medium;

/**
 * @array
 * @sort
 *
 * 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Input: [2,0,2,1,1,0], Output: [0,0,1,1,2,2]
 * 0 1 2 -> red white blue
 *
 * brute force
 * one pass and count all 3 colors
 * scan through again to set values
 *
 * in-place
 * 3 pointers, 0, n - 1 and one in the middle starting from 0 to n - 1
 * move the pointer in the middle (i2 <= i3):
 *   if 0, swap with left pointer, i1++ i2++
 *   if 1, continue, i2++
 *   if 2, swap with right pointer, i3--
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int n = nums.length, i1 = 0, i2 = 0, i3 = n - 1;
        while (i2 <= i3) {
            if (nums[i2] == 1) {
                i2++;
            } else if (nums[i2] == 0) {
                swap(nums, i1, i2);
                i1++;
                i2++;
            } else {
                swap(nums, i2, i3);
                i3--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}