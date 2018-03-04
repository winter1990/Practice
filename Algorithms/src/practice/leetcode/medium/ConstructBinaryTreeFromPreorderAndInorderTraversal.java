package practice.leetcode.medium;

/**
 * binary tree:
 * inorder and preorder given
 * duplicates do not exist in the tree
 * tree 1 2 3 4 null 5 6
 * in   4 2 1 5 3 6
 * pre  1 2 4 3 5 6
 *
 * preorder get the root of the tree/subtree
 * all the element to the left in inorder will be in left subtree, same for right
 *
 * recursion
 * base - root found in inorder arr (index needed in preorder)
 * left if helper(i+1)
 * right?
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[ps]) break;
        }
        TreeNode node = new TreeNode(inorder[i]);
        node.left = helper(preorder, ps + 1, ps + i - is, inorder, is, i - 1);
        node.right = helper(preorder, ps + i - is + 1, pe, inorder, i + 1, ie);
        return node;
    }
}
