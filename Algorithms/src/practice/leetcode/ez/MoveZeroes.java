package practice.leetcode.ez;

/**
 * two indices
 * fast and slow, start from 0
 * [0,1,0,3,12] [1,3,12,0,0]
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int n = nums.length;
        int i = 0; // scan through the arr
        int j = 0; // 0 index

        while (i < n) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
            i++;
        }
    }
}
