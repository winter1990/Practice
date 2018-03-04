package practice.leetcode.ez;

/**
 * root-to-leaf path
 *
 * start with root
 * recursively go down, minus root val
 * leaf is the remaining
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
