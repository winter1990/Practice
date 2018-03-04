package practice.leetcode.ez;

/**
 * maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node
 *
 * dfs, get max
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left ==null && root.right == null) { // this can be deleted
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
