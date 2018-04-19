package practice.leetcode.ez;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @tree
 */
public class TwoSum_IV {
    // dfs O(n) time and O(n) space
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, new HashSet<Integer>());
    }

    private boolean dfs(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(root.val)) {
            return true;
        }
        set.add(k - root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
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
