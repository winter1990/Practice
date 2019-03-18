package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @tree
 *
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 *
 *
 */
public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        int[] width = new int[2];
        getWidthOfTheTree(root, width, 0);
        for (int i = 0; i <= width[1] - width[0]; i++) res.add(new ArrayList<>());


        return res;
    }

    private void getWidthOfTheTree(TreeNode node, int[] width, int level) {
        if (node == null) {
            return;
        }
        width[0] = Math.min(width[0], level);
        width[1] = Math.max(width[1], level);
        getWidthOfTheTree(node.left, width, level - 1);
        getWidthOfTheTree(node.right, width, level + 1);
    }
}
