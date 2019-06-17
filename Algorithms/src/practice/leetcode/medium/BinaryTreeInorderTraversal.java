package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @tree
 *
 * order of traversal:
 *   left
 *   root
 *   right
 *
 * recursive solution
 *   dfs(node.left)
 *   add to result
 *   dfs(node.right)
 *
 * iterative
 * think about the order of traversal:
 *   we go to left until reching the left most
 *   then we need to go upper level to add the root node
 *   then go to right sub tree and repeat the above process
 * how do we know if it is the leftmost already
 *   check if left child is null
 *   OR if reached null, the peek of stack is out next node to be added
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

}
