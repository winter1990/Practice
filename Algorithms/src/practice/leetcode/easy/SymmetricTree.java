package practice.leetcode.easy;

/**
 * @tree
 *
 * need to compare left and right recursively
 * use a helper method with two subtrees' root
 *
 * based case:
 * both null, true
 * either null, false
 * return a.val==b.val helper(left right) (right left)
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}
