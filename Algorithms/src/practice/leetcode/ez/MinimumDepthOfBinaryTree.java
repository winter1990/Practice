package practice.leetcode.ez;

/**
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node
 *
 * always think about some cases first. it must be leaf
 *
 * deal with empty child
 * make sure its leaf
 *
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
