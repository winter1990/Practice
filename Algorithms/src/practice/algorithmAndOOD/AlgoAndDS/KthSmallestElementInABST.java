package practice.algorithmAndOOD.AlgoAndDS;

import java.util.Stack;

/**
 * @tree
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 * method 1
 * traversal order: in-order
 * use a counter to check the kth
 * traverse down the tree and use a stack to track the path, as we finish left subtree, need to go to right
 * when reaching null, we get the smallest in stack
 * if ++count = k, return current node, otherwise go to right
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int counter = 0;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (++counter == k) return cur.val;
                cur = cur.right;
            }
        }
        return Integer.MIN_VALUE;
    }
}
