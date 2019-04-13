package practice.leetcode.easy;

/**
 * Given a Binary Search Tree (BST) with the root node root,
 * return the minimum difference between the values of any two different nodes in the tree.
 *
 * in-order traversal
 * keep track of previous node
 *
 */
public class MinimumDistanceBetweenBSTNodes {
    Integer min = Integer.MAX_VALUE, pre = null;
    public int minDiffInBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        helper(root);
        return min;
    }

    private void helper(TreeNode node) {
        if (node.left != null) {
            helper(node.left);
        }
        if (pre != null) {
            min = Math.min(min, node.val - pre);
        }
        pre = node.val;
        if (node.right != null) {
            helper(node.right);
        }
    }
}
