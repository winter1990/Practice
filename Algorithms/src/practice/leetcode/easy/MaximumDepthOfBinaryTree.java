package practice.leetcode.easy;

/**
 * @tree
 * @recursion
 *
 * maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node
 *
 * base case:
 * null node, return 0
 * keep traversing down, get the max between left and righ subtree, then plus 1 is the current depth
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
