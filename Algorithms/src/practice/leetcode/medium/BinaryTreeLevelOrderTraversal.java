package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @tree
 *
 * start with the root
 * for each level, create a new list
 * count the number of nodes in each level at the beginning before adding new nodes
 * poll from the node with count iterations, and check left and right child, if not null, add to queue
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
