package practice.leetcode.medium;

import java.util.Stack;

/**
 * recursion:
 * store the right child
 * if left, move to right, go to right
 * multiple right children need to be stored, stack
 * while()
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;
            } else {
                if (cur.right == null && !stack.isEmpty()) {
                    cur.right = stack.pop();
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
    }
}
