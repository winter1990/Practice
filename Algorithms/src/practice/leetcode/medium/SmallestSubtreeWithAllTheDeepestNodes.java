package practice.leetcode.medium;


import javafx.util.Pair;

/**
 * @tree
 *
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
 * A node is deepest if it has the largest depth possible among any node in the entire tree.
 * The subtree of a node is that node, plus the set of all descendants of that node.
 * Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
 *
 * if we have the parent reference, easier
 * need to have all the deepest nodes in the tree
 * smallest tree -> if all the deepest nodes are on left or right side, then it's not the smallest
 *
 */
public class SmallestSubtreeWithAllTheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return findDepth(root).getValue();
    }

    private Pair<Integer, TreeNode> findDepth(TreeNode node) {
        if (node == null) {
            return new Pair<>(0, null);
        }
        Pair<Integer, TreeNode> l = findDepth(node.left), r = findDepth(node.right);
        int ld = l.getKey(), rd = r.getKey();
        return new Pair<>(1 + Math.max(ld, rd), ld == rd ? node : ld > rd ? l.getValue() : r.getValue());
    }

}
