package practice.leetcode.ez;

/**
 * @tree
 *
 * recursively traverse down the tree, swap left and right child
 * base condition:
 * node is null, then return null
 * n.left = invert(n.right) so left and right child reference pointing to the same node
 * tmp node to store
 * return root at last
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }


    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
