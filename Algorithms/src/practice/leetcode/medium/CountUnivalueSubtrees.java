package practice.leetcode.medium;

/**
 * recursion
 * leaf is always the one
 */
public class CountUnivalueSubtrees {
    private int res;
    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }

    private boolean helper(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean l = helper(node.left);
        boolean r = helper(node.right);
        if (l && r) {
            if ((node.left != null && node.left.val != node.val) || (node.right != null && node.right.val != node.val)) {
                return false;
            }
            res++;
            return true;
        }
        return false;
    }
}

class Solution {
    int count = 0;
    boolean all(TreeNode root, int val) {
        if (root == null)
            return true;
        if (!all(root.left, root.val) | !all(root.right, root.val))
            return false;
        count++;
        return root.val == val;
    }
    public int countUnivalSubtrees(TreeNode root) {
        all(root, 0);
        return count;
    }
}