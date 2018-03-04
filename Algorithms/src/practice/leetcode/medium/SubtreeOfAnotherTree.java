package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * recursively traverse the two trees
 * if two roots are same,start recursion,level traversal
 * isSameTree(n1,n2)
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.val == t.val && isSameTree(cur, t)) {
                return true;
            }
            if (cur.left != null) q.offer(cur.left);
            if (cur.right != null) q.offer(cur.right);
        }
        return false;
    }

    private boolean isSameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 == null || n2 == null) {
            return false;
        } else if (n1.val != n2.val) {
            return false;
        }
        return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }
}
