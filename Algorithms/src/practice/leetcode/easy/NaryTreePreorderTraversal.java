package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @tree
 *
 * use a stack to track the previous visited nodes
 * push the children to the stack, from last to first
 */
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        traverse(root, res);
        return res;
    }

    private void traverse(Node node, List<Integer> res) {
        res.add(node.val);
        for (Node child : node.children) {
            traverse(child, res);
        }
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            res.add(cur.val);
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.push(cur.children.get(i));
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
