package practice.leetcode.ez;

/**
 * BST, left is small, right is larger
 * in the range, move forward
 * less than L, cut left subtree, keep right
 * more than R, cut right subtree, keep left
 *
 */
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
