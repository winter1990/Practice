package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @tree
 *
 * method 1:
 * level order traversal -> get the first element in each level
 *
 * method 2:
 * dfs
 * need to track the level, as we need to reach the lowest level, so use a global variable to track the res and lowest level
 * for dfs, always start with left child, then right child. so if current level is larger than what we have traversed
 * then we update result
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = root.val;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) res = q.peek().val;
                TreeNode cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        return res;
    }

    int maxLevel = -1, res = 0;
    public int findBottomLeftValue1(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level > maxLevel) {
            res = node.val;
            maxLevel = level;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
