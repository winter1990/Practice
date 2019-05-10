package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @tree
 *
 * Input:
 *   1
 *    \
 *     2
 *    / \
 *   3   4
 * Ouput:
 * [1, 3, 4, 2]
 *
 * Input:
 *     ____1_____
 *    /           \
 *   2            3
 *  / \          /
 * 4   5        6
 *    / \      / \
 *   7   8    9  10
 * Ouput:
 * [1,2,4,7,8,9,10,6,3]
 *
 * intuition:
 * the boundary consists of left most nodes for each level + right most nodes for each level + all leaves
 * level order traversal -> redundant
 * get left, right and leaves separately
 */
public class BoundaryOfBinaryTree {
    List<Integer> nodes = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return nodes;
        nodes.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return nodes;
    }

    public void leftBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        nodes.add(root.val);
        if (root.left == null) {
            leftBoundary(root.right);
        } else {
            leftBoundary(root.left);
        }
    }

    public void rightBoundary(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) return;
        nodes.add(root.val);
        if (root.right == null) {
            rightBoundary(root.left);
        } else {
            rightBoundary(root.right);
        }

    }

    public void leaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}
