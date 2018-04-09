package practice.leetcode.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @tree
 * @stack
 *
 * post order: left -> right -> root
 * start with root node, go to leftmost node
 * then go to right subtree, repeat the iteration
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (pre == null || pre.left == cur || pre.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else if (cur.left == pre) {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else {
                res.add(cur.val);
                stack.pop();
            }
            pre = cur;
        }
        return res;
    }

    // linked list support addFirst() function to add the object at the front
    // post order left-right-root
    // if always add node at front of result list
    // the traversal order becomes root-right-left
    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return res;
    }
}
