package practice.leetcode.medium;

import java.util.Stack;

/**
 * @tree
 *
 * Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal
 * to the sum of the values of the original tree that are greater than or equal to node.val
 *
 * problems to solve:
 * 1. ALL the elements that are larger then current node, not only the right subtree
 * 2. how to traverse the tree
 *
 * bst
 * traversal - inorder, preorder, postorder
 * for inorder, it's increasing order, so we implement reversed in-order traversal
 */
public class BinarySearchTreeToGreaterSumTree {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return root;
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.right);
        node.val += sum;
        sum = node.val;
        traverse(node.left);
    }

    public TreeNode bstToGst1(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
