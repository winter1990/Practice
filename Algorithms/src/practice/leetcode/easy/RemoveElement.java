package practice.leetcode.easy;

/**
 * @array
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        int tmp = 0;
        while (i < j) {
            if (nums[i] != val) {
                i++;
            } else {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
            }
        }
        return nums[i] == val ? i : i + 1;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
