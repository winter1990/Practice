package practice.leetcode.ez;

/**
 * if see an decrease
 * - current one might need to delete
 * - decreased one might need to delete
 */
public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int checker = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                checker++;
                if (checker > 1) {
                    return false;
                }
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return checker <= 1;
    }
}
