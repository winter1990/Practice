package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum
 *
 * start from root, go down and minus until leaf
 * need to touch all the leaves, as not bst
 *
 * recursion:
 * base - leaf node & leaf=sum
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
        helper(root, new LinkedList<Integer>(), res, sum);
        return res;
    }

    private void helper(TreeNode node, LinkedList<Integer> list, List<List<Integer>> res, int sum) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        list.add(node.val);
        if (node.left == null && node.right == null && sum == 0) {
            res.add(new LinkedList<>(list));
        } else {
            helper(node.left, list, res, sum);
            helper(node.right, list, res, sum);
        }
        list.remove(list.size() - 1);
    }
}
