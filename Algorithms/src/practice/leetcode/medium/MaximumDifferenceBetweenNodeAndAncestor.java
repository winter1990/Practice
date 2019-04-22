package practice.leetcode.medium;

/**
 * @Tree
 *
 * Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B
 * where V = |A.val - B.val| and A is an ancestor of B.
 *
 * abs() value of a node and its ancestor, need to track both max and min
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int max, int min) {
        if (node == null) return max - min;
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        return Math.max(dfs(node.left, max, min), dfs(node.right, max, min));
    }
}
