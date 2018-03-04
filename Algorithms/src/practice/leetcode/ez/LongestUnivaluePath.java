package practice.leetcode.ez;

/**
 * Given a binary tree, find the length of the longest path where
 * each node in the path has the same value.
 * This path may or may not pass through the root.
 * The length of path between two nodes is represented by the number of edges between them.
 *
 * not from root
 * same value
 * path -> should get left & right
 */

public class LongestUnivaluePath {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxPath(root, root.val);
        return max;
    }

    private int getMaxPath(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int left = getMaxPath(root.left, root.val);
        int right = getMaxPath(root.right, root.val);
        max = Math.max(max, left + right);
        if (val == root.val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
