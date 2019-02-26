package practice.leetcode.hard;

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxPath(root);
        return max;
    }

    private int getMaxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxPath(root.left);
        int right = getMaxPath(root.right);
        int path = Math.max(left, 0) + Math.max(right, 0) + root.val;
        max = max > path ? max : path;
        return root.val + Math.max(Math.max(left, right), 0);
    }
}
