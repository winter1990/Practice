package practice.leetcode.ez;

/**
 * @tree
 * @recursion
 *
 * a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1
 *
 * get height for each node
 * recursively compare left and right, check abs(left, right). O(nlogn)
 */

public class BalancedBinaryTree {
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return isBalanced1(root.left) && isBalanced1(root.right);
    }

    public int getHeight(TreeNode n) {
        if (n == null) {
            return 0;
        }
        return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    }

    /**
     * recursion optimization:
     * check height & check balance at same time
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != Integer.MIN_VALUE;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        if (left == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int right = helper(node.right);
        if (right == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int diff = Math.abs(left - right);
        if (diff > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(left, right) + 1;
    }
}
