package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @tree
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum
 *
 * start from root, go down and minus until leaf
 * need to touch all the leaves, as not bst
 *
 * recursion:
 * base case - reach the leaf node & leaf.val = remaining sum
 * check left, add/minus/go
 * check right, add/minus/go
 * for each recursive call, remove
 */
public class PathSum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        helper(root, sum, new LinkedList<>(), res);
        return res;
    }

    private void helper(TreeNode n, int sum, List<Integer> list, List<List<Integer>> res) {
        if (n == null) {
            return;
        }
        list.add(n.val);
        if (n.left == null && n.right == null && n.val == sum) {
            res.add(new LinkedList<>(list));
        }
        helper(n.left, sum - n.val, list, res);
        helper(n.right, sum - n.val, list, res);
        list.remove(list.size() - 1);
    }
}
