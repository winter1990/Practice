package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @tree
 *
 * Print a binary tree in an m*n 2D string array following these rules:
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 *
 * at first, determine the dimension of the 2D array
 * m -> height of the tree
 * n -> width of the tree
 * the width depends on the depth x^depth - 1
 */
public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        int m = getHeight(root);
        int n = (int) Math.pow(2, m);
        String[][] res = new String[m][n - 1];
        for (int i = 0 ; i < m; i++) Arrays.fill(res[i], "");
        printTree(root, 0, m, 0, n - 2, res);
        List<List<String>> list = new ArrayList<>();
        for (String[] strs : res) {
            list.add(Arrays.asList(strs));
        }
        return list;
    }

    private void printTree(TreeNode node, int row, int m, int st, int end, String[][] res) {
        if (node == null) return;
        if (row >= m) return;
        int mid = (st + end) / 2;
        res[row][mid] = node.val + "";
        printTree(node.left, row + 1, m, st, mid - 1, res);
        printTree(node.right, row + 1, m, mid + 1, end, res);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        PrintBinaryTree pb = new PrintBinaryTree();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        pb.printTree(n1);
    }
}
