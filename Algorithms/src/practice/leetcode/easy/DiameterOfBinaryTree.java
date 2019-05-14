package practice.leetcode.easy;

/**
 * @tree
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
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
        if (root == null) return max;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
