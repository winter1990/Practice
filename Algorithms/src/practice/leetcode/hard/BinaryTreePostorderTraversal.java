package practice.leetcode.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @tree
 * @stack
 *
 * post order: left-right-root
 * leftmost
 * when we pop() something, it's for adding to result
 *
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode cur = root, pre = null;

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
}
