package practice.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @tree
 *
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * method 1 - brute force
 * recursively build the tree
 *
 * base case
 *   start > end, null
 * recursive call
 *   (node start end)
 *   search from start to end, and find the maximum value
 *   assign left child and right child
 * worst case - 5 4 3 2 1, O(N^2)
 *
 * method 2 - optimization
 * [3,2,1,6,0,5] -> [6,3,5,null,2,0,null,null,1]
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] a, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = Integer.MIN_VALUE, index = start;
        for (int i = start; i <= end; i++) {
            if (a[i] > max) {
                index = i;
                max = a[i];
            }
        }
        TreeNode node = new TreeNode(a[index]);
        node.left = buildTree(a, start, index - 1);
        node.right = buildTree(a, index + 1, end);
        return node;
    }

    public static TreeNode constructMaximumBinaryTree1(int[] nums) {
        Deque<TreeNode> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode node = new TreeNode(nums[i]);
            while (!q.isEmpty() && nums[i] > q.getFirst().val) {
                node.left = q.removeFirst();
            }
            if (!q.isEmpty()) {
                q.peek().right = node;
            }
            q.addFirst(node);
        }
        if (q.isEmpty()) return null;
        return q.getLast();
    }

    public static void main(String[] args) {
        constructMaximumBinaryTree1(new int[]{3,2,1,6,0,5});
    }
}
