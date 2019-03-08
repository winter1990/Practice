package practice.leetcode.ez;

/**
 * @array
 *
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 */

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        } else if (nums.length < 2) {
            return nums.length;
        }

        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
