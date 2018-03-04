package practice.leetcode.medium;

import practice.util.TreeBuilder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/*
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
 tree traversal
 in 4 2 1 4 2 3 4
 pr 1 2 4 3 2 4 4
 po 4 2 4 2 4 3 1
 */

/**
 * recursion - O(nlogn)
 *
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) {
            return "#";
        }
        String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) {
            res.add(cur);
        }
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }

    public static void main(String[] args) {
        TreeBuilder tb = new TreeBuilder();
        int[] ar = {1,2,1};
        TreeNode root = tb.buildTree(ar);
        FindDuplicateSubtrees f = new FindDuplicateSubtrees();
        System.out.println(f.findDuplicateSubtrees(root));
    }
}
