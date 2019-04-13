package practice.leetcode.medium;

/**
 * @tree
 *
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree
 * with largest number of nodes in it.
 *
 * intuition:
 * inorder traversal the tree, and if the whole array if increasing, then it's BST
 *
 * problems to solve:
 * 1. check if the subtree is bst
 * 2. number of nodes
 *
 * for bst, left bound and right bound -> initial MAX MIN
 * when traverse down:
 *   if go to left, right bound is root
 *   if go to right, left bound is root
 *   need to count the number of nodes
 * number of nodes:
 *   if current tree is valid -> left+right
 *   if current tree is invalid -> max(left[2], right[2])
 * int[left bound, right bound, count]
 *
 * base condition:
 * if node is null, [left bound, right bound, 0]
 */
public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        int[] res = getLargestTree(root);
        return res[2];
    }

    private int[] getLargestTree(TreeNode node) {
        if (node == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] l = getLargestTree(node.left);
        int[] r = getLargestTree(node.right);
        if (node.val > l[1] && node.val < r[0]) { // valid bst
            return new int[]{Math.min(l[0], node.val), Math.max(r[1], node.val), l[2] + r[2] + 1};
        }
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(l[2], r[2])};
    }
}
