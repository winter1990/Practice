package practice.leetcode.medium;

/**
 * tilt of a tree node is defined as:
 * the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values
 * The tilt of the whole tree is defined as the sum of all nodes' tilt
 * Given a binary tree, return the tilt of the whole tree.
 */
public class BinaryTreeTilt {
    int sum = 0;
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return sum;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        sum += Math.abs(left - right);
        return left + root.val + right;
    }
}
