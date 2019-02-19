package practice.leetcode.ez;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @tree
 *
 * return the bottom-up level order traversal of its nodes' values.
 *
 *
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
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (level == res.size()) {
            List<Integer> newLevel = new LinkedList<>();
            res.add(0, newLevel);
        }
        List<Integer> list = res.get(res.size() - level - 1);
        helper(node.left, level + 1, res);
        helper(node.right, level + 1, res);
        list.add(node.val);
    }
}
