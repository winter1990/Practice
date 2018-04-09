package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @tree
 *
 * level order traversal
 * for each level, go to right first (might be empty), then left
 * total levels = size of result
 * determine the level, pass into recursive call and compare with the size of list
 * add to result if level = result.size()
 * base: null, return
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(root.val);
        }
        helper(root.right, level + 1, res);
        helper(root.left, level + 1, res);
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (i == 0) {
                    res.add(cur.val);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
            }
        }
        return res;
    }
}
