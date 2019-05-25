package practice.leetcode.easy;

/**
 * @array
 *
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new
 * length.
 *
 * [0 0 1 1 1 2 3 4 4]
 * define two pointers:
 *   i = 0, j = 0
 *   if a[i] = a[j], j++
 *   else a[++i] = a[j++]
 *   or simplified as
 *   if (a[i] != a[j]) a[++i]=a[j]
 *   j++
 * at last, i is at the index of non-duplicate array. so return i+1
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
