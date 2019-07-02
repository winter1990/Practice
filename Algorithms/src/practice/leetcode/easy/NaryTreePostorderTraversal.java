package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @tree
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * method 1 - recursion
 * for binary tree post order: left -> right -> root order
 * for n-ary tree
 * the order of traversal:
 *   first child, second child...
 *   recursively traverse each child
 *
 * method 2 - iterative
 * use a stack, push the last child into stack
 */
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        traverse(root, res);
        return res;
    }

    private void traverse(Node node, List<Integer> res) {
        for (Node child : node.children) {
            traverse(child, res);

        }
        res.add(node.val);
    }

    public List<Integer> postorder1(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            res.addFirst(n.val);
            for (int i = 0; i < n.children.size() ; i++) {
                stack.push(n.children.get(i));
            }
        }
        return res;
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
