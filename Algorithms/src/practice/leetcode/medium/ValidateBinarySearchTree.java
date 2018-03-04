package practice.leetcode.medium;

/**
 * left subtree smaller
 * right subtree larger
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
        } else if (root.left == null && root.right == null) {
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

    // this method will not pass the case [Long.MIN, null, Long.MAX]
    public boolean isValidBST1(TreeNode root) {
        return helper1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper1(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return helper1(root.left, minValue, root.val) && helper1(root.right, root.val, maxValue);
    }

    // cc150
    public boolean isValidBST2(TreeNode root) {
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
