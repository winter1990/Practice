package practice.leetcode.ez;

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
            return root;
        } else if (root.left == null && root.right == null) {
            return root;
        }
        invert(root);
        return root;
    }

    public void invert(TreeNode node) {
        if (node.left == null && node.right == null) {
            return;
        } else if (node.left == null) {
            node.left = node.right;
            node.right = null;
            invert(node.left);
        } else if (node.right == null) {
            node.right = node.left;
            node.left = null;
            invert(node.right);
        } else {
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            invert(node.left);
            invert(node.right);
        }

    }
}
