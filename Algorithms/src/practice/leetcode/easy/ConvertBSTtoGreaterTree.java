package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @tree
 *
 * reverse order of in-order traversal
 * because we are suming up all the nodes that larger than current node, so define a global variable for sum
 * start with largest value in the tree
 */
public class ConvertBSTtoGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root);
        return root;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.right);
        node.val += sum;
        sum = node.val;
        helper(node.left);
    }


    // in-order traversal => increasing array/list
    // iterate the list from right to left, sum up
    List<TreeNode> list = new ArrayList<>();
    public TreeNode convertBST1(TreeNode root) {
        if (root == null) {
            return null;
        }
        inorderTraversal(root);
        for (int i = list.size() - 2; i >= 0; i--) {
            TreeNode cur = list.get(i);
            cur.val += list.get(i + 1).val;
        }
        return root;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        list.add(root);
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(13);
        n1.left = n2;
        n1.right = n3;
        ConvertBSTtoGreaterTree c = new ConvertBSTtoGreaterTree();
        System.out.println(c.convertBST(n1) );
    }
}
