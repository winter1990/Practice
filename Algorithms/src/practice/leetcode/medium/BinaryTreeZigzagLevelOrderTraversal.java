package practice.leetcode.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @tree
 *
 * level order traversal
 * reverse the odd number sublists
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(list);
        }
        for (int i = 1; i < res.size(); i+=2) {
            Collections.reverse(res.get(i));
        }
        return res;
    }
}
