package practice.leetcode.medium;

/**
 * @tree
 *
 * Given the root of a binary tree, consider all root to leaf paths: paths from the root to any leaf.
 *
 * A node is insufficient if every such root to leaf path intersecting this node has sum strictly less than limit.
 *
 * Delete all insufficient nodes simultaneously, and return the root of the resulting binary tree.
 *
 * a path is divided into 3 parts:
 *   root to a node
 *   node to the leaf
 *   if a node make the path between root to its larger sub tree between left and right
 * when traversing down the tree
 * bottom up
 * if a node is causing the max between left and right smaller than threshold, then it should be removed
 */
public class InsufficientNodesInRootToLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return null;
    }
}
