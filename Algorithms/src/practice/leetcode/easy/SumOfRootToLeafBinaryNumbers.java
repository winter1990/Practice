package practice.leetcode.easy;

import practice.leetcode.medium.TreeNode;

/**
 * @tree
 *
 *
 */
public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        return getSum(root, 0);
    }

    private int getSum(TreeNode node, int path) {
        if (node == null) {
            return 0;
        }
        path *= 2;
        path += node.val;
        return node.left == node.right ? path : getSum(node.left, path) + getSum(node.right, path);
    }

    int sum = 0;
    public int sumRootToLeaf1(TreeNode root) {
        if (root == null) return 0;
        getPathsSum(root, 0);
        return sum;
    }

    private void getPathsSum(TreeNode node, int path) {
        if (node.left == null && node.right == null) {
            sum += (path * 2 + node.val);
            return;
        }
        if (node.left != null) getPathsSum(node.left, path * 2 + node.val);
        if (node.right != null) getPathsSum(node.right, path * 2 + node.val);
    }
}
