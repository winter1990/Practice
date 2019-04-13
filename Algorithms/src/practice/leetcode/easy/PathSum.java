package practice.leetcode.easy;

/**
 * @tree
 *
 * root-to-leaf path
 *
 * start with root
 * recursively go down, minus root val
 *
 * if node null, false
 * if leaf node and same as remaining value, return true
 * otherwise, go down to left or right
 */

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
