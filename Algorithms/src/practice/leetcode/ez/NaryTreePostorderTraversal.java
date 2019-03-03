package practice.leetcode.ez;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @tree
 *
 * postorder: left -> right -> root order
 *
 */
public class NaryTreePostorderTraversal {
    List<Integer> res = new LinkedList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return res;
        }
        for (Node n : root.children) {
            postorder(n);
        }
        res.add(root.val);
        return res;
    }

    public List<Integer> postorder1(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            res.addFirst(n.val);
            for (Node child : n.children) {
                stack.push(child);
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
