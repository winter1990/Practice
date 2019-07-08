package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @graph
 *
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1,
 * and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for
 * which the edge (i, j) exists.
 *
 * based on description:
 *   there is no cycle in the graph
 *   directed
 *   start from 0, and destination is n-1
 *   all paths
 *
 * for each neighbors/adj nodes, add to path, we go to next recursive call
 * we do not want any circle, if we see current node exists in the path, stop searching
 *
 * base case:
 *   start = end, reach the destination
 *
 * recursive call
 *   (graph start end current path result)
 *   for each neighbor
 *     add to path
 *     next call
 *     remove from the path
 */
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, list, 0, graph.length - 1, res);
        return res;
    }

    private void dfs(int[][] graph, List<Integer> path, int start, int end, List<List<Integer>> res) {
        if (start == end) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[start]) {
            path.add(next);
            dfs(graph, path, next, end, res);
            path.remove(path.size() - 1);
        }
    }
}
