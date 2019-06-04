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
        if (nums.length < 1) return nums.length;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) nums[++i] = nums[j];
        }
        return i + 1;
    }
}
