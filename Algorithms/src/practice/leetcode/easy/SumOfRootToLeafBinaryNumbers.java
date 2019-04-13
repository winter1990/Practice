package practice.leetcode.easy;

import practice.leetcode.medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @tree
 *
 *
 */
public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int val) {
        if (node == null) return 0;
        val *= 2;
        val += node.val;
        return node.left == node.right ? val : dfs(node.left, val) + dfs(node.right, val);
    }

    public int sumRootToLeaf1(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, "", list);
        int res = 0;
        for (String s : list) res += Integer.parseInt(s, 2);
        return res;
    }

    private void dfs(TreeNode node, String s, List<String> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            s += node.val;
            list.add(s);
            return;
        }
        dfs(node.left, s + node.val, list);
        dfs(node.right, s + node.val, list);
    }
}
