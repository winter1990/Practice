package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @tree
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * BFS solution
 * use a queue to do the level order traversal, when reaching a new level, create another sub list, add to index 0
 *
 * DFS solution
 * base case: null, return. recursive traverse the tree until reaching leaf node, check the result size.
 * if level=res.size() add a new list at front. recursively traverse to left, then right child
 */
public class BinaryTreeLevelOrderTraversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int i = queue.size();
            List<Integer> list = new LinkedList<>();
            while (i-- > 0) {
                TreeNode n = queue.poll();
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
                list.add(n.val);
            }
            res.add(0, list);

        }
        return res;
    }

    /**
     * recursion solution
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (level == res.size()) {
            List<Integer> newLevel = new LinkedList<>();
            res.add(0, newLevel);
        }
        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
        List<Integer> list = res.get(res.size() - level - 1);
        list.add(node.val);
    }
}
