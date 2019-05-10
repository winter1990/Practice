package practice.leetcode.hard;

/**
 * @tree
 *
 * A path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child
 * connections. The path must contain at least one node and does not need to go through the root.
 *
 * problems to solve:
 * 1. when traversing down the tree, need to get the max of left, max of right
 * 2. the path is not needed to pass through root, it can be any node in the subtree
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPath(root);
        return max;
    }

    private int getMaxPath(TreeNode root) {
        if (root == null) return 0;
        int left = getMaxPath(root.left);
        int right = getMaxPath(root.right);
        int path = Math.max(left, 0) + Math.max(right, 0) + root.val;
        max = max > path ? max : path;
        return Math.max(root.val + Math.max(left, right), 0);
    }
}
