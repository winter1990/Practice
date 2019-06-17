package practice.leetcode.easy;

import java.util.Stack;

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
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Stack<TreeNode> sp = new Stack<>();
        Stack<TreeNode> sq = new Stack<>();
        sp.push(p);
        sq.push(q);
        while (!sp.isEmpty() && !sq.isEmpty()) {
            TreeNode m = sp.pop();
            TreeNode n = sq.pop();
            if (m.val != n.val) {
                return false;
            }
            if (m.right != null) {
                sp.push(m.right);
            }
            if (n.right != null) {
                sq.push(n.right);
            }
            if (sp.size() != sq.size()) {
                return false;
            }
            if (m.left != null) {
                sp.push(m.left);
            }
            if (n.left != null) {
                sq.push(n.left);
            }
            if (sp.size() != sq.size()) {
                return false;
            }
        }
        return sp.size() == sq.size();
    }
}
