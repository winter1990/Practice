package practice.leetcode.medium;

/*
Input:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
Output: 8
 */

import java.util.LinkedList;
import java.util.List;

/**
 * method1
 * level order traversal,put null. at last, reduce the null at front and end
 *
 * method2
 * mark left node parentid*2
 * mark right node parentid*2+1
 * record the id of leftmost node
 * at each node,compare the distance with left most
 */

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> left = new LinkedList<>();
        return helper(root, 1, 0, left);
    }

    private int helper(TreeNode node, int id, int level, List<Integer> left) {
        if (node == null) {
            return 0;
        }
        if (level >= left.size()) {
            left.add(id);
        }
        return Math.max(id - left.get(level) + 1,
                Math.max(helper(node.left, id * 2, level + 1, left),
                        helper(node.right, id * 2 + 1, level + 1, left)));
    }
}
