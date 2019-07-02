package practice.leetcode.easy;

/**
 * @tree
 *
 * A binary tree is univalued if every node in the tree has the same value.
 *
 * Return true if and only if the given tree is univalued.
 */
public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.val != root.left.val) {
            return false;
        }
        if (root.right != null && root.val != root.right.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public boolean isUnivalTree1(TreeNode root) {
        return isUnival(root, root.val);
    }

    private boolean isUnival(TreeNode node, int val) {
        if (node == null) {
            return true;
        } else if (node.val != val) {
            return false;
        }
        return isUnival(node.left, val) && isUnival(node.right, val);
    }
}
