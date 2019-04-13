package practice.leetcode.easy;

/**
 * @tree
 *
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that
 * the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist,
 * you should return NULL
 *
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        return findTheSubTree(root, val);
    }

    private TreeNode findTheSubTree(TreeNode node, int target) {
        if (node == null) {
            return null;
        }
        if (node.val == target) {
            return node;
        } else if (target > node.val) {
            return findTheSubTree(node.right, target);
        } else {
            return findTheSubTree(node.left, target);
        }
    }
}
