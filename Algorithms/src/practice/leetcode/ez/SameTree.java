package practice.leetcode.ez;

/**
 * @tree
 * @dfs
 *
 * base condition:
 * both null - true
 * either null - false
 * if value same, then we continue with both left subtree and right subtree
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
