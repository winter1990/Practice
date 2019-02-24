package practice.leetcode.medium;

/**
 * @tree
 *
 * 1.full on all levels
 * 2.last level may not
 * 3.left on last level
 * if there is one null,last level
 *
 * level by level - use queue to store nodes
 * determine last level - left/right child null
 * if null found - all the rest nodes' children null
 * at last check q is empty
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * above process is to 'check if tree is complete tree'
 *
 * Given a complete binary tree, count the number of nodes
 * compare the height of left and right subtree
 * if same height,left are complete, left + root = 1 << h, go to right
 * if not same, right subtree is complete, right + root1 << h - 1, go to left
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int left = getLeftMostHeight(root);
        int right = getRightMostHeight(root);
        if (left == right) {
            return (1 << left) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftMostHeight(TreeNode node) {
        int level = 0;
        while (node != null) {
            node = node.left;
            level++;
        }
        return level;
    }

    private int getRightMostHeight(TreeNode node) {
        int level = 0;
        while (node != null) {
            node = node.right;
            level++;
        }
        return level;
    }

    /**
     * brute force / initial method
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
