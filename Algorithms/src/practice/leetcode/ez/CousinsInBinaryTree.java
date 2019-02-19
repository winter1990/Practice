package practice.leetcode.ez;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @tree the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * Each node has a unique integer value
 * <p>
 * get depth for each node
 * keep track of the parent when traversing down the tree
 */
public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size(), xx = -1, yy = -1;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur == null) continue;
                if (cur.val == x) xx = i;
                else if (cur.val == y) yy = i;
                q.offer(cur.left);
                q.offer(cur.right);
            }
            if ((xx % 2 == 0 && yy == xx + 1) || (yy % 2 == 0 && xx == yy + 1)) return false;
            if (xx != -1 && yy != -1) return true;
        }
        return false;
    }
}
