package practice.leetcode.medium;

/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that
shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right
nodes turned into left leaf nodes. Return the new root.
    1          1           4
   / \        / \\        / \
  2   3 =>   2 - 3  =>   5   2
 / \        / \\            / \
4   5      4 - 5           3   1
 */

/**
 * @tree
 *
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

    /*
    1       prev->     1           4
   / \                / \\        / \
  2   3 =>  curr->   2 - 3  =>   5   2
 / \                / \\            / \
4   5       next-> 4 - 5           3   1
     */
    // iterative solution
    public TreeNode upsideDownBinaryTree1(TreeNode root) {
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;

        while (curr != null) {
            next = curr.left;

            // swapping nodes now, need temp to keep the previous right child
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
