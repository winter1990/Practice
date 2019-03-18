package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @graph
 *
 * Given an undirected graph, return true if and only if it is bipartite.
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that
 * every edge in the graph has one node in A and another node in B.
 *
 * need to group all the nodes into two
 * total number of nodes in the graph - graph.length
 * use an array to distinguish colors
 * start from node 0, mark it as 1. check all the adjacent nodes
 * when visiting some node, it can be -1 0 1
 */
public class IsGraphBipartite {
    // dfs solution
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] checker = new int[n];
        for (int i = 0; i < graph.length; i++) {
            if (checker[i] == 0 && !isValid(graph, checker, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int[][] graph, int[] checker, int val, int index) {
        if (checker[index] != 0) {
            return checker[index] == val;
        }
        checker[index] = val;
        for (int neighbor : graph[index]) {
            if (!isValid(graph, checker, -val, neighbor)) {
                return false;
            }
        }
        return true;
    }

    // bfs solution
    public boolean isBipartite1(int[][] graph) {
        int n = graph.length;
        int[] checker = new int[n];
        Queue<Integer> q;
        for (int i = 0; i < n; i++) {
            if (checker[i] != 0) continue;
            q = new LinkedList<>();
            q.offer(i);
            checker[i] = 1;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int neighbor : graph[cur]) {
                    if (checker[neighbor] == 0) {
                        checker[neighbor] = -checker[cur];
                        q.offer(neighbor);
                    } else if (checker[cur] != -checker[neighbor]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
