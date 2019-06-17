package practice.leetcode.easy;

/**
 * @tree
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * recursion:
 * 1. base case: if null then stop, else if reach leaf - add current and return
 * 2. travel down - add current node and arrow sign
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        getPaths(root, "", res);
        return res;
    }

    private void getPaths(TreeNode node, String cur, List<String> res) {
        if (node.left == null && node.right == null) {
            res.add(cur + node.val);
            return;
        }
        if (node.left != null) getPaths(node.left, cur + node.val + "->", res);
        if (node.right != null) getPaths(node.right, cur + node.val + "->", res);
    }
}
