package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @tree
 */
public class TwoSum_IV {
    // dfs O(n) time and O(n) space
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, new HashSet<>());
    }

    private boolean dfs(TreeNode node, int k, Set<Integer> set) {
        if (node == null) {
            return false;
        } else if (set.contains(node.val)) {
            return true;
        }
        set.add(k - node.val);
        return dfs(node.left, k, set) || dfs(node.right, k, set);
    }

    // inorder traversal
    public boolean findTarget1(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, k, list);
        int s = 0;
        int e = list.size() - 1;
        while (s < e) { // O(n)
            int sum = list.get(s) + list.get(e);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                e--;
            } else {
                s++;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, int k, List<Integer> list) { // O(n) space & time
        if (root == null) {
            return;
        }
        inorder(root.left, k, list);
        list.add(root.val);
        inorder(root.right, k, list);
    }

}
