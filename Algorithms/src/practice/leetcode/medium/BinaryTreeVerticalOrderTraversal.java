package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @tree
 *
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * get range first, calculate how many buckets we need
 * then dfs or bfs?
 * for dfs, we go left tree and then right tree, but when we go to left sub tree, the node may be in the same column
 * with righ subtree and if we add it first, then the order will be wrong
 *
 * for bfs
 * level by level, start with root, need two queues -> one for node, one for level #
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int[] range = new int[2];
        getRange(root, range, 0);
        for (int i = 0; i <= range[1] - range[0]; i++) res.add(new ArrayList<>());

        Queue<Integer> indexQ = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        indexQ.offer(-range[0]);
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            int i = indexQ.poll();
            res.get(i).add(cur.val);
            if (cur.left != null) {
                q.add(cur.left);
                indexQ.add(i - 1);
            }
            if (cur.right != null) {
                q.add(cur.right);
                indexQ.add(i + 1);
            }
        }
        return res;
    }

    private void getRange(TreeNode node, int[] range, int col) {
        if (node == null) {
            return;
        }
        range[0] = Math.min(range[0], col);
        range[1] = Math.max(range[1], col);
        getRange(node.left, range, col - 1);
        getRange(node.right, range, col + 1);
    }
}
