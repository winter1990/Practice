package practice.leetcode.ez;

/**
 * sort and check.
 * O(nlogn)
 *
 * replace and check at the same time
 * if correct, negative
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
