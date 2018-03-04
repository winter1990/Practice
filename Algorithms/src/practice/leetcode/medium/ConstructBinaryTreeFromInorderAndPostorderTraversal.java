package practice.leetcode.medium;

/**
 * the tree: 1234null56
 * in 421536
 * po 425631
 *
 * postorder:
 * last one is the root
 * inorder:
 * left subtree and right subtree
 * get last/root again
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (postorder[pe] == inorder[i]) break;
        }
        TreeNode node = new TreeNode(inorder[i]);
        node.left = helper(inorder, is, i - 1, postorder, ps, ps + i - is - 1);
        node.right = helper(inorder, i + 1, ie, postorder, ps + i - is, pe - 1);
        return node;
    }
}
