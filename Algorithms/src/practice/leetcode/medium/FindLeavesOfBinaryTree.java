package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/*
          1
         / \
        2   3
       / \
      4   5
Returns [4, 5, 3], [2], [1]
 */

/**
 * recursion
 * base condition - leaf/left&right child null. too many checking conditions
 *
 * how many sub-lists - height of the tree
 *
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }

    private int helper(TreeNode node, List<List<Integer>> res) {
        if (node == null) {
            return 0;
        }
        int depth = 1 + Math.max(helper(node.left, res), helper(node.right, res));
        if (depth > res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(depth - 1).add(node.val);
        return depth;
    }
}
