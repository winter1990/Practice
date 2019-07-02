package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @tree
 *
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
 * and every node has no left child and only 1 right child.
 *
 * in order traversal
 * save in a list
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = null;
        return list.get(0);
    }

    private void inorder(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }

    // another recursive solution
    public TreeNode increasingBST1(TreeNode root) {
        return traverse(root, null);
    }

    private TreeNode traverse(TreeNode node, TreeNode tail) {
        if (node == null) return tail;
        TreeNode root = traverse(node.left, node);
        node.left = null;
        node.right = traverse(node.right, tail);
        return root;
    }

    public static void main(String[] args) {
        IncreasingOrderSearchTree in = new IncreasingOrderSearchTree();
        TreeNode n1 = new TreeNode(379);
        TreeNode n2 = new TreeNode(826);
        n1.left = n2;
        TreeNode n = in.increasingBST(n1);
        System.out.println(n.val + " " + n.right.val + " " + n.left + " " + n.right.left);
    }
}
