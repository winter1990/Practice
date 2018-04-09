package practice.leetcode.medium;

/**
 * @tree
 * @recursion
 *
 *          1
 *        2   3
 *       4   5
 *             6
 * inorder   4 2 1 5 6 3
 * postorder 4 2 6 5 3 1
 * root is the last element in postorder
 * locate root in inorder, get the number of nodes in left subtree
 * the root of left subtree is the last node in postorder
 * the same for right subtree
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (postorder[pe] == inorder[i]) break;
        }
        TreeNode node = new TreeNode(inorder[i]);
        node.left = buildTree(inorder, is, i - 1, postorder, ps, ps + i - is - 1);
        node.right = buildTree(inorder, i + 1, ie, postorder, ps + i - is, pe - 1);
        return node;
    }
}
