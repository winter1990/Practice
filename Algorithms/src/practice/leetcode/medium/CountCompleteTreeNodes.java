package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @tree
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last
 * level are as far left as possible.
 * It can have between 1 and 2^h nodes inclusive at the last level h.
 *
 * method 1 - brute force
 * level order traversal - use queue to store nodes
 * each time we poll() a node from the queue, count++
 *
 * method 2 - get height of left and right sub tree
 * get height - nlogn
 *
 * method 3 - optimization
 * the properties of the tree
 *   only last level not full
 *   all the leaf nodes are as far left as possible
 *            1
 *      2          3
 *   4     5    6     7
 * 8  8  10
 *
 * we want to skip traversing down the tree if a sub tree is full already
 * getting height of left and right sub tree is not enough to check if the tree is full
 * we can check the depth of left most and right most
 *
 * define two methods to get the depth of leftmost and rightmost
 * if left == right, then it means the tree is full, (1 << left) - 1
 * otherwise
 *   return 1 + getCount(left child) + getCount(right child)
 * time O(logN * logN)
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int l = getLeft(root);
        int r = getRight(root);
        if (l == r) {
            return (1 << l) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeft(TreeNode node) {
        int level = 0;
        while (node != null) {
            node = node.left;
            level++;
        }
        return level;
    }

    private int getRight(TreeNode node) {
        int level = 0;
        while (node != null) {
            node = node.right;
            level++;
        }
        return level;
    }

    /**
     * brute force
     * level order traversal
     * because we know that this is a complete tree, so traverse down the tree level by level and count the # of nodes
     *
     * time: O(n), space: O(logn)
     */
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            count++;
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        return count;
    }
}
