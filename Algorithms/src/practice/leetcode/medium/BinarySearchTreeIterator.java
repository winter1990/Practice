package practice.leetcode.medium;

import java.util.Stack;

/**
 * @design
 * @stack
 * @tree
 *
 * Calling next() will return the next smallest number in the BST.
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree
 *
 * the next smallest number, it means the in-order traversal
 * when we initialize the class, scan the tree
 *
 *
 *
 */
public class BinarySearchTreeIterator {
}

class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushToStack(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        if (cur.right != null) {
            pushToStack(cur.right);
        }
        return cur.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushToStack(TreeNode node) {
        TreeNode cur = node;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
