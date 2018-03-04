package practice.leetcode.medium;

/*
Given a binary tree where all the right nodes are either leaf nodes
with a sibling (a left node that shares the same parent node) or empty,
flip it upside down and turn it into a tree where the original right
nodes turned into left leaf nodes. Return the new root.
    1
   / \
  2   3
 / \
4   5

   4
  / \
 5   2
    / \
   3   1
 */

/**
 * all rights are leaf with sibling or empty
 * the rule - parent->rightChild rightChild->leftLeaf
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
