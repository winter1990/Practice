package practice.leetcode.easy;

import practice.leetcode.medium.TreeNode;

/**
 * @tree
 * @daq
 *
 * divide and conquer:
 * get left
 * get right
 * update tilt
 * return sum
 *
 * tilt of a tree node is defined as:
 * the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values
 * The tilt of the whole tree is defined as the sum of all nodes' tilt
 * Given a binary tree, return the tilt of the whole tree.
 */
public class BinaryTreeTilt {
    int sum = 0;
    public int findTilt(practice.leetcode.medium.TreeNode root) {
        if (root == null) {
            return 0;
        }
        postOrder(root);
        return sum;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        sum += Math.abs(left - right);
        return left + root.val + right;
    }
}
