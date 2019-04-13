package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @tree
 * @bfs
 *
 * 1 [3 [5 6] 2 4]
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int count = q.size();
            while (count-- > 0) {
                for (Node n : q.peek().children) {
                    q.add(n);
                }
                list.add(q.poll().val);
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        helper(root, 1, res);
        return res;
    }

    private void helper(Node node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (level > res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(level - 1).add(node.val);
        for (Node n : node.children) {
            helper(n, level + 1, res);
        }
    }

    class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
