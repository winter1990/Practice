package practice.leetcode.ez;

import practice.algorithmAndOOD.OOD.P;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bottom up recursion
 * return the sum: left + right + root.val
 * base: if null 0, if leaf node value
 */
public class MostFrequentSubtreeSum {
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        helper(root);
        List<Integer> result = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i).size() == max) {
                result.add(i);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        int left = helper(root.left);
        int right = helper(root.right);
        sum = root.val + left + right;
        if (!map.containsKey(sum)) {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            map.put(sum, list);
        } else {
            map.get(sum).add(root);
        }
        max = map.get(sum).size() > max ? map.get(sum).size() : max;
        return sum;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(-5);
        n1.left = n2;
        n1.right = n3;
        MostFrequentSubtreeSum m = new MostFrequentSubtreeSum();
        m.findFrequentTreeSum(n1);
    }
}
