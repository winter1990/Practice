package practice.leetcode.ez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        traverse(root);
        List<Integer> list = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) == max) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            traverse(root.left);
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, map.get(root.val));
        if (root.right != null) {
            traverse(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(2147483647);
        FindModeInBinarySearchTree fb = new FindModeInBinarySearchTree();
        System.out.println(fb.findMode(n)[0]);
    }
}
