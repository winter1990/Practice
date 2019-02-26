package practice.leetcode.hard;

public class RecoverBinarySearchTree {
    TreeNode p, q;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root);
        int tmp = p.val;
        p.val = q.val;
        q.val = tmp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null && root.val < pre.val) {
            if (p == null) {
                p = pre;
                q = root;
            } else {
                q = root;
            }
        }
        pre = root;
        inorder(root.right);
    }
}
