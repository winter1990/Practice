package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @tree
 *
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 *
 * the reason to use tree map:
 * The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time,
 * depending on which constructor is used.
 *
 *
 */
public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        for (int i : map.keySet()) {
            res.add(new ArrayList<>());
            for (int j : map.get(i).keySet()) {
                PriorityQueue<Integer> pq = map.get(i).get(j);
                while (!pq.isEmpty()) res.get(res.size() - 1).add(pq.poll());
            }
        }
        return res;
    }

    private void dfs(TreeNode node, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) return;
        if (!map.containsKey(x)) map.put(x, new TreeMap<>());
        if (!map.get(x).containsKey(y)) map.get(x).put(y, new PriorityQueue<>());

        map.get(x).get(y).offer(node.val);
        if (node.left != null) dfs(node.left, x - 1, y + 1, map);
        if (node.right != null) dfs(node.right, x + 1, y + 1, map);
    }

}
