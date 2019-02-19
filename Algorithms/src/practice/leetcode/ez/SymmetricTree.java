package practice.leetcode.ez;

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
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (l == null || r == null) {
            return false;
        }
        return l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }
}
