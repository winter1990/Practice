package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @tree
 * @stack
 *
 * in-order: left-root-right
 * recursive:
 * left -> add -> right
 *
 * iterative:
 * keep traversing to leftmost node
 * when going down, put root to stack
 * if null, pop stack, put in result, go to right
 * when reaching the root, stack is empty and cur = root.right
 * so when checking stack, also check cur for each iteration
 *
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

}
