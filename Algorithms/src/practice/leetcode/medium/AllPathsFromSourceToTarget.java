package practice.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @graph
 *
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1,
 * and return them in any order.
 *
 * start from 0, and target n-1
 * we start from 0 -> graph[0], for each number in the adj nodes
 * cycle in the graph -> use a boolean array to keep track of the visited nodes, or set
 * for each neighbors/adj nodes, add to path, we go to next recursive call
 * we do not want any circle, if we see current node exists in the path, stop searching
 *
 * base case:
 * reach the target -> the target exists in path
 * recursion - graph, index/node, target, path, res
 */
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        Set<Integer> path = new HashSet<>();
        path.add(0);
        int target = graph.length - 1;
        helper(graph, 0, target, path, res);
        return res;
    }

    private void helper(int[][] graph, int index, int target, Set<Integer> path, List<List<Integer>> res) {
        if (path.contains(target)) {
            res.add(new LinkedList<>(path));
        }
        for (int i : graph[index]) {
            if (path.contains(i)) {
                continue;
            }
            path.add(i);
            helper(graph, i, target, path, res);
            path.remove(i);
        }
    }
}
