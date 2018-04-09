package practice.leetcode.medium;

/*
Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree
 */

import java.util.Stack;

/**
 * @tree
 * @design
 */
public class BinarySearchTreeIterator {
}

class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return node.val;
    }
}
