package practice.leetcode.easy;

import java.util.PriorityQueue;

/**
 * recursively traverse the tree
 * two params to keep track of numbers
 * initially -1,-1
 * all numbers non-neg, each node has 0/2 nodes
 *
 */
public class SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        helper(root, q);
        Integer n1 = q.poll();
        Integer n2 = null;
        while (!q.isEmpty() && n1 == q.peek()) {
            q.remove();
        }
        n2 = q.poll();
        return n2 == null ? -1 : n2;
    }

    private void helper(TreeNode root, PriorityQueue<Integer> q) {
        if (root == null) {
            return;
        }
        q.offer(root.val);
        helper(root.left, q);
        helper(root.right, q);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        System.out.println(q.poll());
    }
}
