package practice.leetcode.medium;

/**
 * What if duplicates are allowed at most twice
 *
 * 1 1 1 2 2 2 3 -> 1 1 2 2 3
 *
 *
 */
public class RemoveDuplicatesFromSortedArray_II {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        } else if (nums.length <= 2) {
            return nums.length;
        }
        int i = 1, j = 2;
        while (j < nums.length) {
            if (nums[i] == nums[j] && nums[i - 1] == nums[j]) j++;
            else nums[++i] = nums[j++];
        }
        return i + 1;
    }
}
