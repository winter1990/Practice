package practice.leetcode.ez;

/**
 * recursion:
 * 1. base case: reach leaf - add current and return
 * 2. travel down - add current
 */

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        helper(res, root, "");
        return res;
    }

    private void helper(List<String> res, TreeNode root, String s) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            s += root.val;
            res.add(s);
            return;
        }
        s = s + root.val + "->";
        helper(res, root.left, s);
        helper(res, root.right, s);
    }
}
