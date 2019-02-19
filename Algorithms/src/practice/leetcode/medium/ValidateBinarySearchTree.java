package practice.leetcode.medium;

/**
 * @tree
 * @recursion
 * @dfs
 *
 * all nodes in left subtree smaller
 * all nodes in right subtree larger
 *
 * set left bound and right bound
 * recursively go down the tree
 * check the node value
 * what if node is MAX/MIN
 *
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        if (root.val == Integer.MIN_VALUE && root.left != null) {
            return false;
        }
        if (root.val == Integer.MAX_VALUE && root.right != null) {
            return false;
        }
        return helper(root.left, min, root.val - 1) && helper(root.right, root.val + 1, max);
    }

    // cc150
    public boolean isValidBST1(TreeNode root) {
        return checkBST(root, null, null);
    }

    private boolean checkBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.val <= min) || (max != null && node.val > max)) {
            return false;
        }
        if (!checkBST(node.left, min, node.val) || !checkBST(node.right, node.val, max)) {
            return false;
        }
        return true;
    }
}
