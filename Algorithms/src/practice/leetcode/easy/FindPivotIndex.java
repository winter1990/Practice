package practice.leetcode.easy;

/**
 * @array
 *
 * We define the pivot index as the index where the sum of the numbers to the left of the index
 * is equal to the sum of the numbers to the right of the index.
 *
 * scan twice, left->right right->left
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length <= 2) return -1;
        int n = nums.length;
        int[] lr = new int[n];
        int[] rl = new int[n];
        for (int i = 1 ; i < n; i++) lr[i] = nums[i - 1] + lr[i - 1];
        for (int i = n - 2; i >= 0; i--) rl[i] = rl[i + 1] + nums[i + 1];
        for (int i = 1; i < n; i++) {
            if (lr[i] == rl[i]) return i;
        }
        return -1;
    }

    public int pivotIndex1(int[] nums) {
        int n = nums.length, total = 0, cur = 0;
        for (int i : nums) total += i;
        for (int i = 0; i < n; i++) {
            if (i != 0) cur += nums[i - 1];
            if (total - nums[i] - cur == cur) return i;
        }
        return -1;
    }
}
