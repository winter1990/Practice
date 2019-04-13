package practice.leetcode.easy;

/**
 * @tree
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * intuition:
 * get height recursively for left and right subtree and update sum - O(NlogN)
 *
 * optimization:
 * when we traverse down the tree, get the max between left and right subtree
 * return the height
 */
public class DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return max;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
