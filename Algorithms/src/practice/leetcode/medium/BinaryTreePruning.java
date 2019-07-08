package practice.leetcode.medium;

/**
 * @tree
 *
 * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 *
 * calculate the sum of subtree, recursively
 * if sum of the subtree is 0, assign null to the child reference
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    public TreeNode pruneTree1(TreeNode root) {
        traverse(root);
        return root;
    }

    public int traverse(TreeNode node) {
        if (node == null) return 0;
        int left = traverse(node.left);
        int right = traverse(node.right);
        if (left == 0 && right == 0 && node.val == 0) return 0;
        if (left == 0) {
            node.left = null;
        }
        if (right == 0) {
            node.right = null;
        }
        return left + right + node.val;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(1);
        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
        BinaryTreePruning bt = new BinaryTreePruning();
        TreeNode n = bt.pruneTree(n1);
        System.out.println();
    }
}
