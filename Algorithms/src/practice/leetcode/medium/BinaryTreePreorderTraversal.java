package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @tree
 * @stack
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }


    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inOrderTraversal(root, res);
        return res;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        inOrderTraversal(root.left, res);
        inOrderTraversal(root.right, res);
    }
}
