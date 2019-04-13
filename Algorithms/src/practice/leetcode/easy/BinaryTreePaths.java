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

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        dfs(res, root, "");
        return res;
    }

    private void dfs(List<String> res, TreeNode root, String s) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            res.add(s + root.val);
            return;
        }
        dfs(res, root.left, s + root.val + "->");
        dfs(res, root.right, s + root.val + "->");
    }
}
