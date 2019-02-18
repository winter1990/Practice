package practice.leetcode.medium;

/**
 * @array
 *
 * duplicates are allowed at most twice
 * 1 1 1 2 2 2 3 -> 1 1 2 2 3
 * do it in place and return the length of sub array
 *
 * two pointers:
 * 1. start at index 1, used to check current and previous elements
 * 2. scan through the array
 * when to move the pointer i and j
 * i ? j and i ? i -1
 *   =         =    j++
 *   =         !    replace ++i j++
 *   !         =    replace ++i j++
 *   !         !    replaec ++i j++
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
            if (nums[i] == nums[j] && nums[i] == nums[i - 1]) {
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }
}
