package practice.leetcode.medium;

import java.util.Stack;

/**
 * @tree
 * @dfs
 *
 * start with root. move all the left node to right and we need to store the previous right nodes
 * use a stack because we are dealing with the latest pushed node first
 * check left child first, if null, then we can move to right child
 * if left not null, then check right, if not null, push to stack
 *
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null) {
            if (cur.left != null) {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                cur.right = cur.left;
                cur.left = null;
            } else {
                if (cur.right == null) {
                    if (!stack.isEmpty()) {
                        cur.right = stack.pop();
                    }
                }
            }
            cur = cur.right;
        }
            /* cleaner
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                cur.right = cur.left;
                cur.left = null;
            } else if(!stack.isEmpty()) {
                cur.right = stack.pop();
            }
            cur = cur.right;
             */
    }

    // recursive solution
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
