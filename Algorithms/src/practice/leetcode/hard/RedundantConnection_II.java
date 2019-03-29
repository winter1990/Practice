package practice.leetcode.hard;

/**
 * @graph
 * @unionfind
 * @tree
 *
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all
 * other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which
 * has no parents.
 * Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes.
 *
 * find the node that has two parents
 * store two edges and make second invalid
 * union find:
 *   if valid tree return second
 *   else if candidates not found, find the loop as normal
 *   else remove first candidate
 */
public class RedundantConnection_II {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1], c1 = {-1, -1}, c2 = {-1, -1};
        for (int[] edge : edges) {
            if (parent[edge[1]] == 0) {
                parent[edge[1]] = edge[0];
            } else {
                c2 = new int[]{edge[0], edge[1]};
                c1 = new int[]{parent[edge[1]], edge[1]};
                edge[1] = 0; // last one
            }
        }
        for (int i = 1; i < parent.length; i++) parent[i] = i;
        for (int[] edge : edges) {
            if (edge[1] == 0) {
                continue;
            }
            int from = edge[0], to = edge[1];
            if (find(parent, from) == to) {
                if (c1[0] == -1) return edge;
                return c1;
            }
            parent[to] = from;
        }
        return c2;
    }

    // this solution can make sure loop is removed, but can not make sure the result is a tree like graph
    // [2 1] [3 1] [4 2] [1 4]
    public int[] findRedundantDirectedConnection1(int[][] edges) {
        int[] root = new int[edges.length + 1];
        for (int i = 1; i < root.length; i++) root[i] = i;
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (find(root, from) == find(root, to) || root[from] != from || root[to] != to) {
                return edge;
            } else{
                root[find(root, to)] = find(root, from);
            }
        }
        return new int[2];
    }

    public int find(int[] root, int node) {
        if (root[node] != node) {
            root[node] = find(root, root[node]);
        }
        return root[node];
    }

    public static void main(String[] args) {

    }
}
