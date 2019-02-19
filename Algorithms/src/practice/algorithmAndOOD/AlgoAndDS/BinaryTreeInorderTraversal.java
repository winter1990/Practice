package practice.algorithmAndOOD.AlgoAndDS;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @tree
 *
 * inorder traversal: left child, root, right child
 * start with left, root, right child
 * before visiting right child, we check left child first
 * need to keep track of the previous/parent node when we traverse down the tree
 * start with root node, while (cur != null) push cur to stack and go to left child
 * cur = stack.pop, add cur to result, go to right
 * when cur node null, it means we reach the leaf, so we need to backtrack to get the previous node stored in stack
 * to control the while() first check current node not null, then if null, we pop from stack
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
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
        if (root == null) {
            return res;
        }
        TreeNode node = root;
        helper(node, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        helper(node.left, res);
        res.add(node.val);
        helper(node.right, res);
    }
}
