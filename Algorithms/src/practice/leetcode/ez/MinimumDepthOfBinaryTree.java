package practice.leetcode.ez;

/**
 * @tree
 * @recursion
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node
 *
 * to the nearest leaf - leaf means left and right child are both null
 */

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root);
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        } else if (node.left == null && node.right == null) {
            return 1;
        }
        return Math.min(helper(node.left), helper(node.right)) + 1;
    }
}
