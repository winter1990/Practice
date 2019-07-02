package practice.leetcode.easy;

/**
 * @array
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
 * the non-zero elements.
 *
 * two pointers
 *   both start from 0
 *   left pointer is the actual position of non-zero element
 *   right pointer walk through the array
 * for right pointer, there are two scenarios:
 *   a[j] not zero, swap with element at i
 *   a[j] is zero, j++
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] in = {0,0,0,1};
        MoveZeroes m = new MoveZeroes();
        m.moveZeroes(in);
    }
}
