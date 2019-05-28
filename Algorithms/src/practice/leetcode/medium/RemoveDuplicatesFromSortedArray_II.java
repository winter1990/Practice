package practice.leetcode.medium;

/**
 * @array
 *
 * duplicates are allowed at most twice
 * 1 1 1 2 2 2 3 -> 1 1 2 2 3
 * do it in place and return the length of sub array
 *
 * problems to solve:
 * 1. remove the elements in place
 * 2. keep track of the in-place index and check a[i]?a[i-1]
 *
 * two pointers:
 *   because duplicates are allowed at most twice. i1 start from 1, used to check a[i1] and a[i2]
 *   scan through the array, compare with a[i1]
 *
 * when to move the pointer i and j
 * ai aj  ai ai-1
 *   =      =    j++
 *   =      !    replace ++i j++
 *   !      =    replace ++i j++
 *   !      !    replace ++i j++
 */
public class RemoveDuplicatesFromSortedArray_II {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;
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
