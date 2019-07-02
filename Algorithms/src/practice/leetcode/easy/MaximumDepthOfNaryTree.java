package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @tree
 *
 * method 1:
 * dfs
 * recursively traverse down the tree
 * base condition:
 * null 0
 * leaf node 1
 * recursively get depth of left and right
 * compare and get the maximum
 *
 * bfs
 * use queue to do the level order traversal
 */
public class MaximumDepthOfNaryTree {
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();
                for (Node node : cur.children) {
                    q.offer(node);
                }
            }
            depth++;
        }
        return depth;
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children.size() == 0) return 1;
        int max = 0;
        for (Node node : root.children) {
            max = Math.max(max, 1 + maxDepth(node));
        }
        return max;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
