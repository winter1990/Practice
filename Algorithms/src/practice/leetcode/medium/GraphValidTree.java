package practice.leetcode.medium;

import java.util.*;

/**
 * @graph
 * @dfs
 *
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 *
 * n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true
 * n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false
 *
 * properties of valid tree
 *   each node has 1 parent, root has no parent
 *   each node can have at most 2 children - 0 / 1 / 2
 *   no loop
 *
 * graph
 *   use 2d array to define a graph
 *   len = n, label [0, n-1]
 *   build the relationship between nodes - graph List<List<Integer>> because label is [0, n-1]
 * dfs
 *   we can start from any node, for example 0
 *   detect if cycle exists
 *     traverse down and visit all neighbors, check if visited and for each step we are traversing DOWN the tree
 *       not visit back parent again
 *     use set to store visited nodes
 */
public class GraphValidTree {
    public boolean validTree1(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(i, new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int p = edges[i][0];
            int q = edges[i][1];
            list.get(p).add(q);
            list.get(q).add(p);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        if (isValid(list, 0, visited, -1)) return false;
        return visited.size() == n;
    }

    private boolean isValid(List<List<Integer>> graph, int node, Set<Integer> visited, int parent) {
        List<Integer> neighbors = graph.get(node);
        for (int nei : neighbors) {
            if (nei == parent) continue;
            if (visited.contains(nei)) return false;
            visited.add(node);
            if (!isValid(graph, nei, visited, node)) return false;
        }
        return true;
    }

    /**
     * @unionfind
     *
     * condition to be a valid tree
     *   all n nodes in the same tree
     *   no cycle in the tree
     *
     * union find method
     *   for each edge, [e[0], e[1]], find the parent for e[0] and e[1]
     *   if they have the same parent
     *   parent[i] represents the parent of i  is parent[i]
     *
     *     0
     *    / \
     *   1   2
     *  /     \
     * 3      5
     *  \
     *   4
     * [0 1] [0 2] [1 3] [2 5] [3 4]
     * [0 1 2 3 4 5]
     *    0
     *      0
     *        0
     *            0
     *          0
     */
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 1; i < n; i++) parent[i] = i;
        for (int[] e : edges) {
            int p0 = find(parent, e[0]);
            int p1 = find(parent, e[1]);
            if (p0 == p1) {
                return false;
            }
            parent[p1] = p0;
        }
        return edges.length == n - 1;
    }

    private int find(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

}
