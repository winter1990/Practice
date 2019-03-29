package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @tree
 *
 * intuition:
 * level order traversal to the upper level
 */
public class AddOneRowToTree {
    public TreeNode addOneRow1(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        dfs(root, d, 1, v);
        return root;
    }

    private void dfs(TreeNode node, int d, int level, int v) {
        if (node == null) return;
        if (level < d - 1) {
            dfs(node.left, d, level + 1, v);
            dfs(node.right, d, level + 1, v);
        } else {
            TreeNode left = node.left;
            node.left = new TreeNode(v);
            node.left.left = left;

            TreeNode right = node.right;
            node.right = new TreeNode(v);
            node.right.right = right;
        }
    }


    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (--d > 1) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode l = node.left;
            node.left = new TreeNode(v);
            node.left.left = l;
            TreeNode r = node.right;
            node.right = new TreeNode(v);
            node.right.right = r;
        }
        return root;
    }


}
