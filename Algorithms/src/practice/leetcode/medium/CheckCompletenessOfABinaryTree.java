package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @tree
 *
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes
 * inclusive at the last level h.
 *
 * all the nodes in last level should be at left
 *

 */
public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.peek() != null) {
            TreeNode cur = q.poll();
            q.offer(cur.left);
            q.offer(cur.right);
        }
        while (!q.isEmpty()) {
            if (q.poll() != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * wrong method:
     * level order traversal if null, then put null in the queue and define the flag as true, if see another non-null node
     * then it's false.
     * if it is complete tree, put a null and when we
     * this is only correct when it is not a complete tree
     * if it's complete tree, n = null and q.offer() is incorrect
     */
    public boolean isCompleteTree1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur = root;
        q.offer(cur);
        boolean isNullSeen = false;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode n = q.poll();
                if (n == null) {
                    isNullSeen = true;
                }
                if (n != null && isNullSeen) {
                    return false;
                }
                q.offer(n.left == null ? null : n.left);
                q.offer(n.right == null ? null : n.right);
            }
        }
        return true;
    }
}
