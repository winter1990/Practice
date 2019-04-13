package practice.leetcode.easy;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int m, int n) {
        if (m > n) {
            return null;
        }
        if (m == n) {
            return new TreeNode(nums[m]);
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = m; i <= n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums, m, index - 1);
        root.right = helper(nums, index + 1, n);
        return root;
    }
}
