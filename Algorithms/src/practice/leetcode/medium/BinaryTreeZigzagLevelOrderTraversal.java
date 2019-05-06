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
 *
 * method 1 - bfs
 * level order traversal
 * check the size of result
 * for each level, create a new sublist
 *   if size is odd, then current level is even level - add to list
 *   if size is even, then current level is odd level - add to the head of list
 *
 * method 2 - dfs
 * base case:
 *   if null, return
 *   if level >= res.size(), means we are traversing to a new level, create a new sublist and add to result
 * recursion:
 *   get the list in current level
 *   check the level
 *     if odd, add to head
 *     if even, add to tail
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

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
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
            res.add(newLevel);
        }
        List<Integer> list = res.get(level);
        if (level % 2 == 0) {
            list.add(node.val);
        } else {
            list.add(0, node.val);
        }
        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }
}
