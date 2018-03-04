package practice.util;

import practice.leetcode.medium.TreeNode;

public class TreeBuilder {
    public TreeNode buildTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] arr, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = helper(arr, s, mid - 1);
        n.right = helper(arr, mid + 1, e);
        return n;
    }
}
